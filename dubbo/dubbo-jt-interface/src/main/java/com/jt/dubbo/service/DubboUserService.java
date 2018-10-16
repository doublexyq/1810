package com.jt.dubbo.service;

import com.jt.dubbo.pojo.User;

public interface DubboUserService {
	boolean findCheckUser(String param, Integer type);

	void saveUser(User user);

	String findUserByUP(User user);
}
