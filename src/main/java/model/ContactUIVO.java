package model;

import lombok.Data;

@Data
public class ContactUIVO
{
    public ContactUIVO(String name, String img){
        this.name = name;
        this.img = img;
    }
    private String name;
    private String img;
}
