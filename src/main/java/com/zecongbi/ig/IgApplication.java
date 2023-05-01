package com.zecongbi.ig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IgApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgApplication.class, args);
	}

}
