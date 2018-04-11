package com.ggr.entity;

import java.io.Serializable;
/**
 * 留言区
 * @author gr
 *
 */
public class Critique implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;    	//id
	private String content;	//评论
	private String name;	//姓名
	private String time;	//时间
	private String photo;	//照片
	private Integer articleId;	//评论主题
	private String type;	//类型
	private String notice;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	
	
}
