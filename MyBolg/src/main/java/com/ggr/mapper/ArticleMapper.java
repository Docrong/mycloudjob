package com.ggr.mapper;

import java.awt.Image;
import java.util.List;

import org.apache.ibatis.annotations.*;

import com.ggr.entity.Article;
import com.ggr.entity.UserInfo;

@Mapper
public interface ArticleMapper {
	
	/*
	 * 通过id查询文章
	 */
	@Select(value="select *from Article where id=#{id} and deleted='0'")
	Article findArticleById(String id);
	
	/*
	 * 将文章标记为删除
	 * @param id
	 */
	@Update(value = { "update Article set deleted='1' where id=#{id}" })
	void deleteArticle(String id);
	
	/* 查询所有文章
	 * @return
	 */
	List<Article> findAllArticle();
	
	/*
	 * 增加文章
	 */
	void insertArticle(Article article);
	void updateArticle(Article article);
}
