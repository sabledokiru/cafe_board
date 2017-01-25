package com.sabio.cafe.users.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sabio.cafe.users.dto.UsersDto;
import com.sabio.cafe.users.service.UsersService;

@Controller

public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/users/{url}")
	public void authsignup_FormAndSignin_Form(@PathVariable String url){}
	
	@RequestMapping("/users/signup")
	public String authsignUp(@ModelAttribute UsersDto dto){
		usersService.insert(dto);
		return "redirect:/home.do";
	}
	
	@RequestMapping("/users/signin")
	public ModelAndView authsignin(HttpSession session, @RequestParam String uri, @ModelAttribute UsersDto dto){
		ModelAndView mView = new ModelAndView();
		boolean isValid=usersService.isValid(dto);
		if(isValid){
			session.setAttribute("id",dto.getId());
			mView.addObject("msg", dto.getId()+"님 로그인 되었습니다.");
			mView.addObject("redirectUri", uri);
		}else{
			mView.addObject("msg", "아이디 혹은 비밀번호가 틀려요!");
			String location="signin_form.do?uri="+uri;
			mView.addObject("redirectUri", location);
		}
		mView.setViewName("/users/alert");
		return mView;
	}
	
	@RequestMapping("/users/signout")
	public ModelAndView authsignOut(HttpSession session, @RequestParam String uri){
		session.invalidate();
		ModelAndView mView = new ModelAndView();
		mView.addObject("msg", "로그 아웃 되었습니다.");
		mView.addObject("redirectUri", uri);
		mView.setViewName("/users/alert");
		return mView;
	}
	
	@RequestMapping("/users/private/{url}")
	public  void authinfoAndUpdateForm(HttpSession session,Model model){
		String id = (String)session.getAttribute("id");
		model.addAttribute("dto", usersService.getData(id));
	}
	
	@RequestMapping("/users/private/update")
	public String authupdate(UsersDto dto){
		usersService.update(dto);
		return "redirect:/users/private/info.do";
	}
	@RequestMapping("users/private/delete")
	public String authdelete(HttpSession session){
		String id = (String)session.getAttribute("id");
		usersService.delete(id);
		session.invalidate();
		return "redirect:/home.do";
	}
	
}
