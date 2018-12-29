package br.com.vertigo.pessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Application.class, args);
    }
    
    
    //PARA RODAR COM O JBOSS
    private static Class<Application> applicationClass = Application.class;
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
  
    
    
}
