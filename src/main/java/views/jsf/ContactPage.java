package views.jsf;

import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


import domain.Contact;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.ContactService;

//@ManagedBean
@Component
@SessionScoped
@Data
public class ContactPage {

    @Autowired
    ContactService contactService;

    private List<Contact> listContacts ;
    private String inputText;
    private String showMessage;
    private String header= "!!!!!!!!";
    private String[] sa = new String[]{""};

    public ContactPage(){
        listContacts = new ArrayList<>(Arrays.asList(
                new Contact( null,"Боря", "Михайлович", "Моисеев", "111-222", "boris.png", new HashSet<>()),
                new Contact( null,"БорисКО", "Михайлович", "Моисеев", "222-333", "boris.png", new HashSet<>())
        ));
    }

public void AddContact(){
    this.inputText = "wwwwww2222";
    Contact newContact = new Contact( null,"Борис", "Михайлович", "Моисеев", "322-233", "boris.png", new HashSet<>());

    newContact = contactService.addContact(newContact);

    if(newContact!=null){
        this.listContacts.add(newContact);
        //this.setListContacts(this.listContacts);
    }
}


}
