package com.forum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.forum.entity.Post;
import com.forum.respository.PostRepository;
import com.forum.service.CategoryService;
import com.forum.service.PostService;

@Controller
public class TopicPageController {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/topic/{category}/{page}")
	public String showTopicPage(@PathVariable("category") int category, @PathVariable("page") int page, ModelMap model) {
		List<Post> list = postService.getPageSortElement(page - 1, 5, "id_post", category);		
		model.addAttribute("list", list);
		model.addAttribute("category", categoryService.findById(list.get(0).getCategory()).getName());

		if (postRepository.countRecord(category)%5 != 0) {
			model.addAttribute("amountOfPage", postRepository.countRecord(category)/5 + 1);
		} else {
			model.addAttribute("amountOfPage", postRepository.countRecord(category)/5);
		}
		return "topicPage";
	}
	
	@GetMapping("/topic")
	public String showTopicPage1() {	
		return "topicPage";
	}
}
