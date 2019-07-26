package com.czort.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VaadinPocApplication {
	public static void main(String[] args) {
		SpringApplication.run(VaadinPocApplication.class, args);
	}
}
