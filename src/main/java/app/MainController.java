package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping(value = { "/testJsp*" }, method = RequestMethod.GET)
    public String testJspView(HttpServletRequest request) {
        String restOfTheUrl = ((String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE)).substring(1);

        System.out.println(restOfTheUrl);
        return restOfTheUrl; //
        //return "testJsp";
    }

    @RequestMapping(value = { "/jspx/**" }, method = RequestMethod.GET)
    public String testJspView1(HttpServletRequest request) {
        String restOfTheUrl = ((String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE)).substring(5);

        System.out.println(restOfTheUrl);
        return restOfTheUrl; //
        //return "testJsp";
    }

    @RequestMapping(value = { "/testThymeleaf" }, method = RequestMethod.GET)
    public String testThymeleafView() {

        return "th_page1";
    }

    @RequestMapping(value = { "/testFreeMarker" }, method = RequestMethod.GET)
    public String testFreeMarkerView() {

        return "testFreeMarker";
    }

}