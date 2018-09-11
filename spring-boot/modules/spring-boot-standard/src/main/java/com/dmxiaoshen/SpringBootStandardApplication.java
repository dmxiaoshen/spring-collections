package com.dmxiaoshen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:security.properties")
public class SpringBootStandardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStandardApplication.class, args);
	}
}
