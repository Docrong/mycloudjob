package com.ggr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggr.entity.Article;
import com.ggr.entity.UserInfo;
import com.ggr.service.ArticleService;
import com.ggr.service.UserService;

@Controller
public class IndexController {
	@Autowired
	private UserService userService;
	@Autowired 
	private ArticleService articleService;

	/**
	 * 查询用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("finduser")
	public List<UserInfo> findUser() {
		return userService.findAll();
	}
	
	/**
	 * findById
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("user/{id}")
	public UserInfo findById(@PathVariable int id) {
		return userService.findOne(id);
	}
	
	@ResponseBody
	@RequestMapping("article/{id}")
	public List findAllArticle(@PathVariable int id) {
		return articleService.findAllArticle();
	}
	
}