package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class BookClient_8002Application {
	public static void main(String[] args) {
		SpringApplication.run(BookClient_8002Application.class, args);
	}
}
