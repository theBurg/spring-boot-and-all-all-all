package app.jsf;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.SessionScoped;

@SessionScoped
@Setter
@Getter
public class GuestPreferences {

    @Setter(AccessLevel.PUBLIC)
    @Getter(AccessLevel.PUBLIC)
    private String userTheme = new String ("bootstrap");

}