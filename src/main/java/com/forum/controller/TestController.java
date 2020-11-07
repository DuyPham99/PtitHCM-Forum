package com.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {
	
	@RequestMapping("test")
	String test() {
		return "test";
	}
}
