package com.imooc.miaosha.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.imooc.miaosha.domain.User;

@Mapper
public interface UserDao {

	@Select("select * from user where id=#{userId}")
	public User getById(@Param("userId") int userId);

	@Insert("insert into user(id, name) values(#{id}, #{name})")
	public void insert(User user);
	
}
