package com.forum.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.forum.entity.Comment;
import com.forum.entity.Post;
import com.forum.service.CategoryService;
import com.forum.service.PostService;

@Controller
public class PageController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/pageContent/{idPost}")
	String showPage(ModelMap model, @PathVariable ("idPost") int idPost) {
		Post post = postService.findById(idPost);
		String category = categoryService.findById(post.getCategory()).getName();
		model.addAttribute("post", post);
		model.addAttribute("category", category);	
		return "pageContent";
	}
}
