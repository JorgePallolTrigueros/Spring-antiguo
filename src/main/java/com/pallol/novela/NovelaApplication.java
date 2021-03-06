package com.pallol.novela;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.pallol.novela"}) 
public class NovelaApplication implements WebMvcConfigurer{
 
	public static void main(String[] args) {
		SpringApplication.run(NovelaApplication.class, args);
	}

}
