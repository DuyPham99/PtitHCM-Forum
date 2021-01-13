package com.forum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.HttpResource;

import com.forum.service.UserService;

@Component
public class LoggerInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(userService.findById(request.getSession().getAttribute("username").toString()).getRole() );
		if (userService.findById(request.getSession().getAttribute("username").toString()).getRole().equalsIgnoreCase("ADMIN")) {
			return true;
		}
		return false;
	}
	
	@Override
	   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	           ModelAndView modelAndView) throws Exception {
//	       System.out.println("\n-------- LogInterception.postHandle --- ");
//	       System.out.println("Request URL: " + request.getRequestURL());
	   }
	 
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	           throws Exception {
		   
	   }
}
