package com.dmxiaoshen.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 不加exclude = SecurityAutoConfiguration.class
 * 则会报Caused by: java.lang.ArrayStoreException: sun.reflect.annotation.TypeNotPresentExceptionProxy
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootActiviti6Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActiviti6Application.class, args);
	}
}
