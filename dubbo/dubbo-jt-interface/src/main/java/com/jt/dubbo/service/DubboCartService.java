package com.jt.dubbo.service;

import java.util.List;

import com.jt.dubbo.pojo.Cart;

public interface DubboCartService {
	//通过userId查询购物车列表
	List<Cart> findCartListByUserId(Long userId);
	//插入购物车列表数据
	void saveCart(Cart cart);
	//更新购物车商品数量
	void updateCartNum(Cart cart);
}
