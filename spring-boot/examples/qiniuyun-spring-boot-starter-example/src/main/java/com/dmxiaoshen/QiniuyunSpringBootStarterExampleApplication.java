package com.dmxiaoshen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:security.properties")
public class QiniuyunSpringBootStarterExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(QiniuyunSpringBootStarterExampleApplication.class, args);
	}
}
