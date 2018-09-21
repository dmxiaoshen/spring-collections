package com.dmxiaoshen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(basePackages = {"com.dmxiaoshen.dao"})
@ImportResource("classpath:tcc-transaction.xml")
public class SpringBootTccTransactionExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTccTransactionExampleApplication.class, args);
	}
}
