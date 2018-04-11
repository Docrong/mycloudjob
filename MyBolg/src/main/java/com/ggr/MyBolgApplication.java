package com.ggr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MyBolgApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBolgApplication.class, args);
	}
}
