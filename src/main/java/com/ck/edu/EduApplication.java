package com.ck.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ck.edu.mapper")
public class EduApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduApplication.class, args);
	}

}
