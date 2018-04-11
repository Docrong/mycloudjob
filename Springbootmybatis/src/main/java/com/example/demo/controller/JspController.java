package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspController {

	/**
	 * <dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>
	 */
	@RequestMapping("HelloWorld")
	public String test1(){
		System.out.println("HelloWorld");
		return "HelloWorld";
	}
	
	@RequestMapping("upload")
	public String upload(HttpServletRequest request,HttpServletRequest response){
		request.setAttribute("uploadTest1", "123");
		return "upload";
	}
	@RequestMapping("uploadAction")
	public String uploadAction(HttpServletRequest request,HttpServletRequest response){
		System.out.println("上传文件成功"+request.getParameter("username"));
		return "uploadAction";
	}
}
