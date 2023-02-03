package com.example.cartservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class CartservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartservicesApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplateBuiler() {
		return new RestTemplate();
	}

}
