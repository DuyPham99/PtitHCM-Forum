package com.forum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forum.service.UserService;

@Controller
public class AccountController {

	@Autowired
	UserService userService;
	
	@GetMapping("/setting")
	public String showSetting(HttpServletRequest rq, ModelMap model) {
		model.addAttribute("profile", userService.findById( (String) rq.getSession().getAttribute("username")).getProfile());
		return "setting-account";
	}
}
