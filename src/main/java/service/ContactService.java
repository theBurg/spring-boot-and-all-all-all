package service;

import domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import repository.ContactDAO;

@Component
public class ContactService {

    @Autowired
    ContactDAO contactDAO;

    @Transactional(rollbackFor = {}, noRollbackFor = {})
    public Contact addContact(Contact contact){
        //contactDAO.findByPhoneNumber("322233");
        if(contactDAO.existsByPhoneNumber("322233")){
            return null;
        }
        return contactDAO.save(contact);
    }
}
