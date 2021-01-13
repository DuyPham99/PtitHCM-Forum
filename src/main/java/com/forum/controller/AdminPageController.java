package com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.forum.entity.Post;
import com.forum.entity.User;
import com.forum.respository.PostRepository;
import com.forum.respository.UserRepository;
import com.forum.service.PostService;
import com.forum.service.UserService;

@Controller
public class AdminPageController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PostService postService;
	
	@GetMapping("/admin/dashboard")
	public String showDashboard() {
		return "/admin/dashboard";
	}
	
	@GetMapping("/admin/table/{page}")
	public String showTable(@PathVariable("page") int page, ModelMap model) {
		model.addAttribute("list", userService.getPageUser(page));
		long size =  userRepository.count();
	
		if (size % 5 != 0 || size/5 == 0) {
			model.addAttribute("numberPage", size/5 + 1);
		} else model.addAttribute("numberPage", size/5 );
		return "/admin/table";
	}
	
	@PostMapping("/admin/table/delete/{username}")
	@ResponseStatus(HttpStatus.OK)
	public void showUsername(@PathVariable("username") String username, ModelMap model) {
		User user = userService.findById(username);
		user.setDelete(1);
		userService.save(user);
	}
	
	@PostMapping("/admin/table/update/{username}/{role}")
	@ResponseStatus(HttpStatus.OK)
	public void changeRole(@PathVariable("role") String role, @PathVariable("username") String username) {
		User user = userService.findById(username);
		user.setRole(role);
		userService.save(user);
	}
	
	@GetMapping("/admin/post/{page}")
	public String showPost(@PathVariable("page") int page, ModelMap model) {
		List<Post> list = postService.getPageSortElementAdmin(page - 1, 5, "id_post");		
		model.addAttribute("list", list);
		long size = postRepository.count();
		if (size % 5 != 0 || size/5 == 0) {
			model.addAttribute("size", size/5 + 1);
		} else model.addAttribute("size", size/5 );
		return "/admin/post";
	}
	
	@PostMapping("/admin/post/delete/{isPost}")
	@ResponseStatus(HttpStatus.OK)
	void  deletePost(@PathVariable("isPost") int id, ModelMap model) {
		postService.delete(postService.findById(id));
	}
	
}
