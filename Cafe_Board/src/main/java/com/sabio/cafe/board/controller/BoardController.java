package com.sabio.cafe.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sabio.cafe.board.dto.BoardDto;
import com.sabio.cafe.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("cafe/list")
	public ModelAndView list(HttpServletRequest request, @RequestParam(defaultValue="1") int pageNum){
		ModelAndView mView = boardService.getList(request, pageNum);
		return mView;
	}
	
	@RequestMapping("/cafe/private/{url}")
	public void insertForm(@PathVariable String url){
	
	}
	
	@RequestMapping("/cafe/private/insert")
	public String insert(@ModelAttribute BoardDto dto){
		boardService.insert(dto);
		return "redirect:/cafe/list.do";
	}
	
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(@RequestParam int num){
		ModelAndView mView = boardService.getData(num);
		return mView;
	}
	
	@RequestMapping("/cafe/private/delete")
	public String delete(@RequestParam int num){
		boardService.delete(num);
		return "redirect:/cafe/list.do";
	}
	
	@RequestMapping("/cafe/private/updateform")
	public ModelAndView updateform(@RequestParam int num){
		ModelAndView mView = boardService.getData(num);
		return mView;
	}
	
	@RequestMapping("/cafe/private/update")
	public String update(@ModelAttribute BoardDto dto){
		boardService.update(dto);
		return "redirect:/cafe/list.do";
	}

}
