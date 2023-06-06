package com.Bankexample.Bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import  org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankApplication {

	@Value("${customer.service.base-url}")
    private String CUSTOMER_SERVICE_URL;
    
	
	
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public WebClient webClient() {
	WebClient webClient =  WebClient.builder().baseUrl(CUSTOMER_SERVICE_URL).build();
	return webClient;
	}

}
