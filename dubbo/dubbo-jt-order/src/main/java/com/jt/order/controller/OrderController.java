package com.jt.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.vo.SysResult;
import com.jt.dubbo.pojo.Order;
import com.jt.dubbo.service.DubboOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private DubboOrderService orderService;
	private static ObjectMapper objectMapper = new ObjectMapper();

	//http://order.jt.com/order/query/"+id;
	@RequestMapping("/query/{orderId}")
	@ResponseBody
	public Order findOrderById(@PathVariable String orderId){
		
		return orderService.findOrderById(orderId);
	}
	
	
	
	
	
}
