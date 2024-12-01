package com.Seproject.planmate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.Seproject.planmate.mapper")
public class PlanmateApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanmateApplication.class, args);
	}

}
