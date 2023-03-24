package com.example.managerusers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.managerusers", "com.example.managerusers.mapper"})
@OpenAPIDefinition(info = @Info(title = "Users Manager API", version = "1.0.0", description = "Users Information"))
public class ManagerUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerUsersApplication.class, args);
	}

}
