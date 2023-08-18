package com.Gorbunov.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/application.properties")
public class SpringbootappApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootappApplication.class, args);
	}

}
