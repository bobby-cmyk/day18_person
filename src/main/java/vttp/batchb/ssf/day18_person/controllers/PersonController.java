package vttp.batchb.ssf.day18_person.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import vttp.batchb.ssf.day18_person.models.Person;
import vttp.batchb.ssf.day18_person.services.PersonService;

@Controller
@RequestMapping
public class PersonController {

    @Autowired
    private PersonService personSvc;
    
    @GetMapping(path={"/", "/index"})
    public ModelAndView getIndex() {

        ModelAndView mav = new ModelAndView();

        mav.addObject("person", new Person());
        mav.setViewName("person-create");

        return mav;
    }

    @PostMapping("/create")
    public ModelAndView createContact(
        @Valid Person person,
        BindingResult bindings) {

        ModelAndView mav = new ModelAndView();

        if (bindings.hasErrors()) {

            mav.setViewName("person-create");

            return mav;
        }

        personSvc.createContact(person);

        mav.setViewName("redirect:/contacts");
        
        return mav;
    }

    @GetMapping("/contacts")
    public ModelAndView getAllContacts() {
        ModelAndView mav = new ModelAndView();

        List<Person> contacts = personSvc.getAllContacts();

        mav.addObject("contacts", contacts);
        mav.setViewName("person-listings");

        return mav;
    }
}
