package com.doublesix.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.doublesix.ssm.pojo.User;

public interface UserService {
	List<User> findAll();
	public User get(@Param("id") Integer id);
	public void insert(User user);
	public void update(User user);
	public void delete(@Param("id")Integer id);
}
