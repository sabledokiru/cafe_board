package com.sabio.cafe.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabio.cafe.shop.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;

	
	@RequestMapping("/shop/index")
	public void index(Model model){
		List<String> info = new ArrayList<String>();
		
		info.add("개미 특별 SALE");
		info.add("10%의 뽀나쓰 뽀인트 적립!!");
		info.add("열심히 일한 당신 기회를 놓치지 마세욧!");
		
		model.addAttribute("info", info);
	}
	
	
	
	
	
}
