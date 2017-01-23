package com.sabio.cafe.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sabio.cafe.board.dao.BoardDao;
import com.sabio.cafe.board.dto.BoardDto;

@Component
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	@Override
	public void insert(BoardDto dto) {
		boardDao.insert(dto);
		
	}

	@Override
	public void update(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelAndView getData(int num) {
		BoardDto dto = boardDao.getData(num);
		boardDao.increaseViewCount(num);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto", dto);
		return mView;
	}

	@Override
	public ModelAndView getList() {
		ModelAndView mView = new ModelAndView();
		List<BoardDto> list = boardDao.getList();
		mView.addObject("list", list);
		return mView;
	}

	@Override
	public boolean isValid(BoardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

}
