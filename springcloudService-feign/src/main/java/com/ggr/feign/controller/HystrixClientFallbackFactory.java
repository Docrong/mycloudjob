package com.ggr.feign.controller;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements HystrixClient {

	@Override
	public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
