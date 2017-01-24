package com.sabio.cafe.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sabio.cafe.shop.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService shopService;
}
