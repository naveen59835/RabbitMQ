package com.niit.userauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient

public class UserauthserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserauthserviceApplication.class, args);
	}

}
