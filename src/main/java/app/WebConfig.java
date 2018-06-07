package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/", "/templates/site/index");
//
//        registry.addViewController("/templates/site/index")
//                .setViewName("site/index");
//    }

//    @Bean
//    public ViewResolver viewResolver() {
//        UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
//        urlBasedViewResolver.setViewClass(JstlView.class);
//        urlBasedViewResolver.setPrefix("/WEB-INF/pages/");
//        urlBasedViewResolver.setSuffix(".jspx");
//
//        return urlBasedViewResolver;
//    }
}