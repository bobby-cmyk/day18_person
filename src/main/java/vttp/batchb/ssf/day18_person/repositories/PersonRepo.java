package vttp.batchb.ssf.day18_person.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepo {

    @Autowired
    @Qualifier("redis-0")
    RedisTemplate<String, String> template;
    
    // set fullName contact
    public void createContact(String fullName, String contact) {
        template.opsForValue().set(fullName, contact);
    }

    // keys *
    // get fullName contact
    public List<String> getAllContacts() {
        
        List<String> allContacts = new LinkedList<>();

        Set<String> keys = template.keys("*");

        for (String key : keys) {
            String contact = template.opsForValue().get(key);
            allContacts.add(contact);
        }

        return allContacts;
    }

}
