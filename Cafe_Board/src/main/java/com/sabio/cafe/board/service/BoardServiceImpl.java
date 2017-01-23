package com.sabio.cafe.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.sabio.cafe.board.dao.BoardDao;
import com.sabio.cafe.board.dto.BoardDto;

@Component
public class BoardServiceImpl implements BoardService{

	private static final int PAGE_ROW_COUNT=5;
	private static final int PAGE_DISPLAY_COUNT=5;
	
	@Autowired
	private BoardDao boardDao;
	@Override
	public void insert(BoardDto dto) {
		boardDao.insert(dto);
		
	}

	@Override
	public void update(BoardDto dto) {
		boardDao.update(dto);
		
	}

	@Override
	public void delete(int num) {
		boardDao.delete(num);
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
	public ModelAndView getList(int pageNum) {
		
		//보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		//전체 row 의 갯수를 DB 에서 얻어온다.
		int totalRow = boardDao.getCount();
		//전체 페이지의 갯수 구하기
		int totalPageCount=
				(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//시작 페이지 번호
		int startPageNum=
			1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		//끝 페이지 번호가 잘못된 값이라면 
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount; //보정해준다. 
		}
		
		BoardDto dto = new BoardDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		
		
		ModelAndView mView = new ModelAndView();
		List<BoardDto> list = boardDao.getList(dto);
		mView.addObject("list", list);
		mView.addObject("pageNum", pageNum);
		mView.addObject("startPageNum", startPageNum);
		mView.addObject("endPageNum", endPageNum);
		mView.addObject("totalPageCount", totalPageCount);
		return mView;
	}

	@Override
	public boolean isValid(BoardDto dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ModelAndView updateForm(int num) {
		BoardDto dto = boardDao.getData(num);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto",dto);
		return mView;
	}

}
