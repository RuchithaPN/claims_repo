package com.claim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableFeignClients
@CrossOrigin
public class ClaimMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimMicroApplication.class, args);
		System.out.println("Running....");
	}

}
