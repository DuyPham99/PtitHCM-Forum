package com.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

 
@SpringBootApplication
@ComponentScan("com.forum")
public class ForumPtitApplication extends SpringBootServletInitializer {
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ForumPtitApplication.class);
    }
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ForumPtitApplication.class, args);
    }
}