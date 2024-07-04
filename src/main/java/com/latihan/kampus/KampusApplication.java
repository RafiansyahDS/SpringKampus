package com.latihan.kampus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages= "com.latihan.kampus.repository")
public class KampusApplication {

	public static void main(String[] args) {
		SpringApplication.run(KampusApplication.class, args);
	}

}
