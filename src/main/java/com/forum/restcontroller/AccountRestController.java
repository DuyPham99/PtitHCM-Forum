package com.forum.restcontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.forum.entity.Comment;
import com.forum.entity.Post;
import com.forum.entity.Profile;
import com.forum.entity.User;
import com.forum.service.ProfileService;
import com.forum.service.UserService;

@RestController
public class AccountRestController {
	
	@Autowired
	UserService userService;

	@Autowired
	ProfileService profileService;
	
	@PostMapping("/create/setting/save")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	void save(@Valid @RequestBody Profile profile, HttpServletRequest request,ModelMap model) {	
		profileService.save(profile);
	}
	
}
