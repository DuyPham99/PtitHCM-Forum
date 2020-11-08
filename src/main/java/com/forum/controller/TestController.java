package com.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping("test")
	String test() {
		return "rich-text-editor";
	}
	@PostMapping("save")
	String save(@ModelAttribute("editor") String text, Model model) {
		System.out.println(text);
		model.addAttribute("text", text);
		return test();
	}
}
