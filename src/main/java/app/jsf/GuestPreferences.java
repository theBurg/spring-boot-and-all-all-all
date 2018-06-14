package app.jsf;

import lombok.Data;

import javax.faces.bean.SessionScoped;

@SessionScoped
@Data
public class GuestPreferences {

    private String userTheme = new String ("bootstrap");

}