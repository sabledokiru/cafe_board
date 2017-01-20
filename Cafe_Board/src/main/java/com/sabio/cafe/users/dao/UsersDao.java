package com.sabio.cafe.users.dao;

import java.util.List;

import com.sabio.cafe.users.dto.UsersDto;

public interface UsersDao {

	public void insert(UsersDto dto);
	public void update(UsersDto dto);
	public void delete(String id);
	public UsersDto getData(String id);
	public List<UsersDto> getList();
	public boolean isValid(UsersDto dto);
	
}
