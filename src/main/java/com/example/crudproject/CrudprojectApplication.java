package com.example.crudproject;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScans;
//@EntityScan(basePackages = {"com.example.crudproject.service.WalletService", "com.example.crudproject.repository.WalletRepository"})

@SpringBootApplication
public class CrudprojectApplication {

	public static void main(String[] args) {

		 SpringApplication.run(CrudprojectApplication.class, args);



	}



}
