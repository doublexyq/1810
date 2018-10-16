package com.doublesix.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doublesix.ssm.pojo.User;
import com.doublesix.ssm.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/findUser")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping("/getUser/{id}")
	public User getUser(@PathVariable("id")Integer id){
		return userService.get(id);
	}
	
	@RequestMapping("/insert/{name}/{birthday}/{address}")
	public String insert(User user){
		try {
			userService.insert(user);
			return "insert success";
		} catch (Exception e) {
			e.printStackTrace();
			return "insert error";
			
		}
	}
	
	@RequestMapping("/update/{name}/{birthday}/{address}/{id}")
	public String update(User user){
		try {
			userService.update(user);
			return "update success";
		} catch (Exception e) {
			e.printStackTrace();
			return "update error";
			
		}
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id")Integer id){
		try {
			userService.delete(id);
			return "delete success";
		} catch (Exception e) {
			e.printStackTrace();
			return "delete error";
			
		}
	}
}
