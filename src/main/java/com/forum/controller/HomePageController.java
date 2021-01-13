package com.forum.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forum.respository.PostRepository;
import com.forum.service.PostService;
import com.forum.service.UserService;

@Controller
public class HomePageController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	PostRepository postRespository;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String homepage(ModelMap model, HttpSession session) {
		model.addAttribute("active", postRespository.getActivePost());
		model.addAttribute("study", postRespository.getStudyPost());
		model.addAttribute("club", postRespository.getClubPost());
		model.addAttribute("talk", postRespository.getTalkPost());
		model.addAttribute("exp", postRespository.getExpPost());
		model.addAttribute("another", postRespository.getAnotherPost());
		if (session.getAttribute("username") != null)
		model.addAttribute("user", userService.findById(session.getAttribute("username").toString()));
		return "index";
	}
}
