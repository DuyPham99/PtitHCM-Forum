package com.forum.controller;




import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.forum.entity.Post;
import com.forum.security.JwtUtil;

@Controller
public class PostController {

	@GetMapping("/post")
	public String showPost(HttpServletRequest request, ModelMap model) throws IOException {
		if (request.getSession().getAttribute("username") == null)
		return "redirect:/";
		
		Post post = new Post(); 
		model.addAttribute("post", post);
		return "post";
	}
}
