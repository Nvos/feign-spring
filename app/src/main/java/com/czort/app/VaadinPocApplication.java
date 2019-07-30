package com.czort.app;

import com.czort.app.properties.StandardProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(StandardProperties.class)
public class VaadinPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaadinPocApplication.class, args);
	}

}
