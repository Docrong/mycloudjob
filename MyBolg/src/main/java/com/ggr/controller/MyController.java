package com.ggr.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ggr.entity.Article;
import com.ggr.service.ArticleService;
import com.ggr.service.UserService;

@Controller
public class MyController {
	@Autowired
	private UserService userService;
	@Autowired 
	private ArticleService articleService;

	
	@RequestMapping("/hello")
    public String helloHtml(Model model,HttpServletRequest request,HttpServletResponse response,Map map){
//        map.put("hello","hell3o");
//        System.out.println("输出:");
//		System.out.println(""+request.getRequestURI());
		model.addAttribute("ll", "你很好看");
		String str=request.getParameter("userName");
//		System.out.println("str-->"+str);
//		str=(String) map.get("in2");
//		System.out.println("str2-->"+str);
		request.setAttribute("in2", "in2的值");
		
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		session.setAttribute("usrid", "session的值");

		
        return "/hello";
    }
	
	@RequestMapping("/index")
	public String indexHtml(String id,Model model,HttpServletRequest request){
		request.getSession();
		System.out.println("id-->"+id);
		return "/index";
	}
	
	@RequestMapping("/hello2")
    public String hello2(HttpServletRequest request,HttpServletResponse response,Map map) throws Exception{
		System.out.println("map:"+map);
		String str=request.getParameter("in1");
		System.out.println("str-->"+str);
		str=(String) map.get("in2");
		System.out.println("str2-->"+str);
		map.put("hello", "helloworld");
		Article a=new Article();
		a.setTitle("测试");
		a.setContent("测试");
		a.setEditer("admin");
//		articleService.insertArticle(a);
		
		
		return "/hello2";
	}
	
	
}
