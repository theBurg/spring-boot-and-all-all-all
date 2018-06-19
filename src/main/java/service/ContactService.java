package service;

import domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import repository.ContactDAO;

@Component
public class ContactService {

    @Autowired
    ContactDAO contactDAO;

    @TransactionalEventListener
    public Contact addContact(Contact contact){
        //contactDAO.findByPhoneNumber("322233");
        if(contactDAO.existsByPhoneNumber("322233")){
            return null;
        }
        return contactDAO.save(contact);
    }



}
