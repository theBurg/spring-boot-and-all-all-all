package views.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Arrays;
import java.util.List;

import dto.Contact;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


//@ManagedBean
@Component
@SessionScoped
@Data
public class MainPage {

    public String getHeader() {
        return header;
    }

    private String header= "!!!!!!!!";
    private String[] sa = new String[]{""};

    public MainPage(){
        listContacts = Arrays.asList(new Contact("Боря", "boris.png"),new Contact("Боря", "boris.png"));
    }


    public List<Contact> getListContacts() {
        return listContacts;
    }

    private List<Contact> listContacts ;


    private String inputText;
    private String showMessage;


}
