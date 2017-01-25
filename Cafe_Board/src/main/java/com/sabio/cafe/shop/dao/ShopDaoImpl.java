package com.sabio.cafe.shop.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDaoImpl implements ShopDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void deposit(String id, int money) {
	
		// 아이디와 금액을 Map에 담는다.
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("money", money);
		session.insert("shop.deposit", param);
		
	}

	@Override
	public void withDraw(String id, int money) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("money", money);
		session.update("shop.withDraw", param);
	}

	@Override
	public void addPoint(String id, int point) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		param.put("point", point);
		session.update("shop.addPoint", param);
		
	}
	@Override
	public void deliveryRequest() {
		// 트랜잭션을 관리하는 블럭에 Custom Exception 을 발생시켜서
		// 종류별로 Exception을 핸들링 할 수 있다.
		throw new OopsException("오늘은 일개미가 쉬어요.. 배송 못해요!!");
		//System.out.println("배송 요청을 했어요!");
		
	}

}
