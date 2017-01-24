package com.sabio.cafe.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sabio.cafe.users.dao.UsersDao;
import com.sabio.cafe.users.dto.UsersDto;

@Component
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDao usersDao;
	
	@Override
	public void insert(UsersDto dto) {
		usersDao.insert(dto);
		
	}

	@Override
	public void update(UsersDto dto) {
		usersDao.update(dto);
		
	}

	@Override
	public void delete(String id) {
		usersDao.delete(id);
		
	}

	@Override
	public UsersDto getData(String id) {
		
		return usersDao.getData(id);
	}

	@Override
	public ModelAndView getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(UsersDto dto) {
	
		return usersDao.isValid(dto);
	}

}
