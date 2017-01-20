package com.sabio.cafe.board.service;


import org.springframework.web.servlet.ModelAndView;

import com.sabio.cafe.board.dto.BoardDto;

public interface BoardService {
	public void insert(BoardDto dto);
	public void update(BoardDto dto);
	public void delete(String id);
	public ModelAndView getData(String id);
	public ModelAndView getList();
	public boolean isValid(BoardDto dto);
}
