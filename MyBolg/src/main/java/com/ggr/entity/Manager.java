package com.ggr.entity;

import java.io.Serializable;
/**
 * 
 * @author gr
 * 用户,提供登录功能
 *	提供注册,登录功能
 */
public class Manager implements Serializable {


	private static final long serialVersionUID = 1L;
	private String id;
	private String account;//账户
	private String password;//密码
	private String role;	//角色名
	private String notice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
