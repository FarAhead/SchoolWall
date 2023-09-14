package com.example.schoolwall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")      //用于扫描Mapper包
public class SchoolWallApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolWallApplication.class, args);
	}

}
