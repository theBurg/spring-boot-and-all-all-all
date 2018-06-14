package dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Contact
{
    public Contact(String name, String img){
        this.name = name;
        this.img = img;
    }
    private String name;
    private String img;
}
