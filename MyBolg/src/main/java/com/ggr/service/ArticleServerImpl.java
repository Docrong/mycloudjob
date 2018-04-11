package com.ggr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggr.entity.Article;
import com.ggr.mapper.ArticleMapper;

@Service
public class ArticleServerImpl implements ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	@Override
	public List findAllArticle() {
		return articleMapper.findAllArticle();
	}
	@Override
	public void insertArticle(Article article) {
		articleMapper.insertArticle(article);
	}

	
}
