package com.ggr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.ggr.entity.UserInfo;

@Mapper
public interface UserMapper {
	
	/**
	 * findOne
	 * @param id
	 * @return
	 */
	@Select(value="select *from boot_user where id=#{id}")
	UserInfo findOne(int id);
	
	@Insert(value = { "" })
	UserInfo addOne();

	@Delete(value = { "" })
	UserInfo delete();
	/**
	 * findAll
	 * @return
	 */
	List<UserInfo> findAll();
}
