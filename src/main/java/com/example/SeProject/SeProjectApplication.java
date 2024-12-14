package com.example.SeProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.SeProject.mapper")
@SpringBootApplication(scanBasePackages = "com.example.SeProject")
public class SeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeProjectApplication.class, args);
	}

}
