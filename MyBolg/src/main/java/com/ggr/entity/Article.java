package com.ggr.entity;

import java.io.Serializable;
/**
 * 文章
 * @author gr
 *
 */
public class Article implements Serializable{

	/**文章
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;		//id
	private String title;	//标题
	private String content; //内容
	private String image;	//图片
	private String time;	//时间
	private String editor;	//作者
	private String type;	//标记类型
	private String notice;
	private Integer count1;//评论次数
	private Integer count;	//浏览次数
	private String keywords;//关键字
	private String deleted;//删除标识位 0--正常 1--删除
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditer(String editor) {
		this.editor = editor;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
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
	public Integer getCount1() {
		return count1;
	}
	public void setCount1(Integer count1) {
		this.count1 = count1;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	
	
}
