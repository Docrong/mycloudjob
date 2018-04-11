package com.ggr.service;

import java.util.List;

import com.ggr.entity.Article;

public interface ArticleService {

	List findAllArticle();
	void insertArticle(Article article);
}
