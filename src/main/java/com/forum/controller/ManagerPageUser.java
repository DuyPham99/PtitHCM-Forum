package com.forum.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.forum.respository.PostRepository;

@Controller
public class ManagerPageUser {
	
	@Autowired
	PostRepository postRepository;
	
	@GetMapping("/manage-post-user")
	public String show(ModelMap model, HttpServletRequest request) {
		model.addAttribute("list", postRepository.getPostOfUser( (String) request.getSession().getAttribute("username")));
		return "manage-post-user";
	}
}
