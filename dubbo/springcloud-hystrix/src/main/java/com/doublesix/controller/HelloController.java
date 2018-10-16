package com.doublesix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doublesix.client.EurekaServiceFeigh;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@RestController
public class HelloController {
	@Autowired
	private EurekaServiceFeigh eurekaServiceFeigh;
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod="helloFallback")
	public String hello(@PathVariable String name){
		return eurekaServiceFeigh.hello(name);
	}
	
	public String helloFallback(String name){
		return "tony";
	}
}
