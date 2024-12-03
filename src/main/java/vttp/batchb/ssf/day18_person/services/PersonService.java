package vttp.batchb.ssf.day18_person.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batchb.ssf.day18_person.models.Person;
import vttp.batchb.ssf.day18_person.repositories.PersonRepo;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepo personRepo;

    public void createContact(Person person) {

        String fullName = person.getFullName();

        String contact = person.toString();

        personRepo.createContact(fullName, contact);
    }

    public List<Person> getAllContacts() {
        
        List<String> allContactsString = personRepo.getAllContacts();

        List<Person> allContacts = new LinkedList<>();

        for (String contactString : allContactsString) {
            Person contact = Person.StringToPerson(contactString);

            allContacts.add(contact);
        }
        
        return allContacts;
    }
}


