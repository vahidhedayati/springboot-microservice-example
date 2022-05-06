package com.vh.test.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryAppApplication.class, args);
	}

}
