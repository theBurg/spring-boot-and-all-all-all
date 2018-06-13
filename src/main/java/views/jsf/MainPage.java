package views.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@ManagedBean
@SessionScoped
@Getter
@Setter
public class MainPage {
    @Setter(AccessLevel.NONE)
    @Getter
    String[] sa = new String[]{""};

    @Setter @Getter
    private List<String> list = Arrays.asList(sa);

    private String inputText;
    private String showMessage;


}
