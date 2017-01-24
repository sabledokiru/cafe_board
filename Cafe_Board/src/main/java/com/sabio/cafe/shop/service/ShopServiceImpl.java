package com.sabio.cafe.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sabio.cafe.shop.dao.ShopDao;

@Component
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDao shopDao;
	
	// 가상의 입금 작업을 하는 method
	@Override
	public void deposit(String id, int money) {
	
		
	}

	// 가상의 구입 작업을 하는 method
	@Override
	public void buy(String id, int price) {
	
		
	}

}
