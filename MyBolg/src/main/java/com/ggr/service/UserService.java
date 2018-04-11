package com.ggr.service;

import java.util.List;

import com.ggr.entity.UserInfo;

public interface UserService {
	/**
	 * findAll
	 * @return
	 */
	List<UserInfo> findAll();
	
	UserInfo findOne(int id);
}
