package com.sabio.cafe.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class LoginAspect {

	@Around("execution(* com.sabio.cafe.users.controller.UsersController.auth*(..))")
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		 
		// Controller에 Aop를 적용했을때 HttpServletRequest 참조값 얻어오기
		ServletRequestAttributes attrs=(ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attrs.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("id")==null){
			String uri=request.getRequestURI();
			String path="/users/signin_form.do?uri="+uri;
			
			ModelAndView mView = new ModelAndView();
			mView.setViewName("redirect:"+path);
		
			return mView;
		}else{
			return joinPoint.proceed();
		}
	}
}
