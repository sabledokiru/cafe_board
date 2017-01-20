package com.sabio.cafe.users.service;

import org.springframework.web.servlet.ModelAndView;

import com.sabio.cafe.users.dto.UsersDto;

public interface UsersService {
	public void insert(UsersDto dto);
	public void update(UsersDto dto);
	public void delete(String id);
	public ModelAndView getData(String id);
	public ModelAndView getList();
	public boolean isValid(UsersDto dto);
}
