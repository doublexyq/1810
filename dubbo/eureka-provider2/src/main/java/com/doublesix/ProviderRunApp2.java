package com.doublesix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class ProviderRunApp2 {
	public static void main(String[] args) {
		SpringApplication.run(ProviderRunApp2.class, args);
	}
}
