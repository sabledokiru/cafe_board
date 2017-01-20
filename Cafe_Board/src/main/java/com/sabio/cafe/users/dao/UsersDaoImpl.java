package com.sabio.cafe.users.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sabio.cafe.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(UsersDto dto) {
		
		session.insert("users.insert", dto);
		
	}

	@Override
	public void update(UsersDto dto) {
		
		session.update("users.update", dto);
		
	}

	@Override
	public void delete(String id) {
	
		session.delete("users.delete", id);
		
	}

	@Override
	public UsersDto getData(String id) {

		UsersDto dto = session.selectOne("users.getData", id);
		return dto;
	}

	@Override
	public List<UsersDto> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(UsersDto dto) {
		UsersDto resultDto = session.selectOne("users.isValid",dto);
	
		if(resultDto == null){
			return false;
		}else{
			return true;
		}
		
	}

}
