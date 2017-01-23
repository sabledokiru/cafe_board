package com.sabio.cafe.board.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.sabio.cafe.board.dto.BoardDto;

public interface BoardService {
	public void insert(BoardDto dto);
	public void update(BoardDto dto);
	public void delete(int num);
	public ModelAndView getData(int num);
	public ModelAndView getList(HttpServletRequest request, int pageNum);
	public boolean isValid(BoardDto dto);
	public ModelAndView updateForm(int num);
}
