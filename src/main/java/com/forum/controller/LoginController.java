package com.forum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("login") 	
	public String login(ModelMap model) {
		return "login";
	}	
	
	@GetMapping("/logout") 	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("sdfsdff");
		if (auth != null) {
		    new SecurityContextLogoutHandler().logout(request, response, auth);
		}		
		request.getSession().removeAttribute("username");
		return "redirect:/";
	}	
		
}
