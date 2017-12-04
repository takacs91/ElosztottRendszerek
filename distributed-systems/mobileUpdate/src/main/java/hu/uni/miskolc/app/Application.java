package hu.uni.miskolc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {
	public static SI_Service gateway;
	
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("/si-config.xml");
        gateway = (SI_Service) context.getBean("SI_Service",SI_Service.class);
        
        SpringApplication.run(Application.class, args);
        
        /*gateway.addMobile(
        		new Mobile("S7","2017",Brand.Samsung)
        );*/
    }
}
