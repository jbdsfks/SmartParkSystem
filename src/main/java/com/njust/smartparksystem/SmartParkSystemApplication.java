package com.njust.smartparksystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.njust.smartparksystem.dao")
@EntityScan(basePackages = "com.njust.smartparksystem")
public class SmartParkSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartParkSystemApplication.class, args);
	}
}
