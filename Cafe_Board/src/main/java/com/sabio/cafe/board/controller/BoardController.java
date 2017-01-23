package com.sabio.cafe.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sabio.cafe.board.dto.BoardDto;
import com.sabio.cafe.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("cafe/list")
	public ModelAndView list(){
		ModelAndView mView = boardService.getList();
		mView.setViewName("cafe/list");
		return mView;
	}
	
	@RequestMapping("/cafe/private/insertform")
	public String insertForm(){
		return "cafe/private/insertform";
	}
	
	@RequestMapping("/cafe/private/insert")
	public String insert(@ModelAttribute BoardDto dto){
		boardService.insert(dto);
		return "redirect:/cafe/list.do";
		
	}
}
