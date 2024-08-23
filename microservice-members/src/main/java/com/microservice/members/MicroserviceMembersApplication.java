package com.microservice.members;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceMembersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceMembersApplication.class, args);
	}

}
