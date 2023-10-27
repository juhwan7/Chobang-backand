package com.chobang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChobangApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChobangApplication.class, args);
	}

}
