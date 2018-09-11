package com.dmxiaoshen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@MapperScan(basePackages = {"com.dmxiaoshen.dao"})
@ComponentScan({"com.dmxiaoshen"})
@PropertySource("classpath:security.properties")
public class SpringBootTestExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestExampleApplication.class, args);
	}
}
