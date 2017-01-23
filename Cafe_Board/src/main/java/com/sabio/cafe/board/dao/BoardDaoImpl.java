package com.sabio.cafe.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sabio.cafe.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public void insert(BoardDto dto) {
		session.insert("board.insert",dto);
		
	}

	@Override
	public List<BoardDto> getList() {
		List<BoardDto> list = session.selectList("board.getList");
		return list;
	}

	@Override
	public BoardDto getData(int num) {
		BoardDto dto = session.selectOne("board.getData", num);
		return dto;
	}

	@Override
	public void increaseViewCount(int num) {
		session.update("board.increaseViewCount", num);
	}

	@Override
	public void update(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		session.delete("board.delete", num);
	}

}
