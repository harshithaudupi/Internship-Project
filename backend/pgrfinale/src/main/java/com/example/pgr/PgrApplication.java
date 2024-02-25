package com.example.pgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.example.pgr"})
public class PgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgrApplication.class, args);
		System.out.println("Started :)");
	}

}
