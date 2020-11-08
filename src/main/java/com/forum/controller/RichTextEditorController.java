package com.forum.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("editor")
public class RichTextEditorController {
	
	@RequestMapping("")
	String showEditorPage(Model model) {
		ArrayList<String> listImage = new ArrayList<String>();
		model.addAttribute("listImage", listImage);
		return "rich-text-editor";
	}
}
