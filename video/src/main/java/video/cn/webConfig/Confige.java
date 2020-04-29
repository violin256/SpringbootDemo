package video.cn.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Confige  implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/c").setViewName("c");
        registry.addViewController("/resetinformation").setViewName("resetinformation");
        registry.addViewController("/classify").setViewName("classify");
        registry.addViewController("/detail").setViewName("detail");
        registry.addViewController("/download").setViewName("download");
        registry.addViewController("/favorite").setViewName("favorite");
        registry.addViewController("/help").setViewName("help");
        registry.addViewController("/histrory").setViewName("histrory");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/search").setViewName("search");
        registry.addViewController("/type").setViewName("type");
        registry.addViewController("/userc").setViewName("userc");
    }
}
