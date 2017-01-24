package com.sabio.cafe.shop.dao;

public interface ShopDao {

	public void deposit(String id, int money);
	public void widthDraw(String id, int money);   
	public void addPoint(String id, int point);
	public void deliveryRequest();
}