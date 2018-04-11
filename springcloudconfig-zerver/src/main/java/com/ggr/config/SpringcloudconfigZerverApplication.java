package com.ggr.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer//启配置服务器的功能
public class SpringcloudconfigZerverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudconfigZerverApplication.class, args);
	}
}
