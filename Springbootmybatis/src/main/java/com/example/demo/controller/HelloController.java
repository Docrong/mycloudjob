package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class HelloController {
	@RequestMapping("/test/test")
	public String test(){
		System.out.println("跳转HTML");
		return "login";
	}
	
}
