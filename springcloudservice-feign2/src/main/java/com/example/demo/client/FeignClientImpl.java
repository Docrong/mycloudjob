package com.example.demo.client;

import org.springframework.stereotype.Component;

@Component
public class FeignClientImpl implements FeignClient {

	@Override
	 public String sayHiFromClientOne(String name) {
        return "FEIGN ->sorry "+name;
    }
	
}
