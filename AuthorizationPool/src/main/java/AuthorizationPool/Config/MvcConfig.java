package AuthorizationPool.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/userPage").setViewName("userPage");
        registry.addViewController("/adminPage").setViewName("adminPage");
        registry.addViewController("/403Page").setViewName("403Page");
        registry.addViewController("/edit").setViewName("forEdit/edit");
        registry.addViewController("/edit1").setViewName("forEdit/edit1");
        registry.addViewController("/edit2").setViewName("forEdit/edit2");
        registry.addViewController("/edit3").setViewName("forEdit/edit3");
        registry.addViewController("/edit4").setViewName("forEdit/edit4");
        registry.addViewController("/edit5").setViewName("forEdit/edit5");
    }
}
