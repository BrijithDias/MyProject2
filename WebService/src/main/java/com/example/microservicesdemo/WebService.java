package com.example.microservicesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(useDefaultFilters=false)
@EnableDiscoveryClient
public class WebService {
	 public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-SERVICE";
	 
	public static void main(String[] args) {
	    System.setProperty("spring.config.name", "web-service");
		SpringApplication.run(WebService.class, args);
	}
	
	    @LoadBalanced    // Make sure to create the load-balanced template
	    @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
    
	    @Bean
	    public WebAccountsService accountsService() {
	        return new WebAccountsService(ACCOUNTS_SERVICE_URL);
	    }

	    @Bean
	    public WebAccountsControllers accountsController() {
	         return new WebAccountsControllers
	                       (accountsService());  // plug in account-service
	    }

}
