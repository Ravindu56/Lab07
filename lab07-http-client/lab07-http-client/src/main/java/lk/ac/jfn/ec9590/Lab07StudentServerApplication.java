package lk.ac.jfn.ec9590.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Lab07StudentServerApplication extends SpringBootServletInitializer {

    // Required for external Tomcat WAR deployment
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Lab07StudentServerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab07StudentServerApplication.class, args);
    }
}