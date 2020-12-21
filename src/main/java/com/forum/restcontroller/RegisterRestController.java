package com.forum.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.forum.entity.User;
import com.forum.service.UserService;

@RestController
public class RegisterRestController {
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> Register(@Valid @RequestBody User user) {
		if (userService.isValidAccount(user) == 1) {
			return new ResponseEntity<>("User was existed!", HttpStatus.BAD_REQUEST);
		} else if (userService.isValidAccount(user) == 2) {
			return new ResponseEntity<>("User was existed!", HttpStatus.BAD_REQUEST);
		}
		user.setRole("USER");
		user.setPassword(userService.encrypPassword(user.getPassword()));
		userService.save(user);	
		return ResponseEntity.ok("");
	}
}
