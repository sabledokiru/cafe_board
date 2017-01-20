package com.sabio.cafe.board.dao;

import java.util.List;

import com.sabio.cafe.board.dto.BoardDto;

public interface BoardDao {
	
	public void insert(BoardDto dto);
	public List<BoardDto> getList();
	public BoardDto getData(int num);
	public void increaseViewCount(int num);
	public void update(BoardDto dto);
	public void delete(int num);
	
}
