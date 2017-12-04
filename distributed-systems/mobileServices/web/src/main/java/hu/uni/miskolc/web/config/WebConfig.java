package hu.uni.miskolc.web.config;

import hu.uni.miskolc.controller.MobileManagerController;
import hu.uni.miskolc.dao.MobileDAODummy;
import hu.uni.miskolc.service.MobileManagerService;
import hu.uni.miskolc.service.MobileSearchService;
import hu.uni.miskolc.service.dao.MobileDAO;
import hu.uni.miskolc.service.impl.MobileManagerServiceImpl;
import hu.uni.miskolc.service.impl.MobileSearchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hu.uni.miskolc.web.config")
public class WebConfig {

    @Bean
    public MobileDAO mobileDAO(){
        return new MobileDAODummy();
    }

    @Bean
    public MobileManagerService mobileManagerService(){
        return new MobileManagerServiceImpl(mobileDAO());
    }

    @Bean
    public MobileSearchService mobileSearchService(){
        return new MobileSearchServiceImpl(mobileDAO());
    }

    @Bean
    public MobileManagerController mobileManagerController(){
        return new MobileManagerController(mobileManagerService(),mobileSearchService());
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
  
}
