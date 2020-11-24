package com.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.forum.entity.CustomUserDetail;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub		
		
		com.forum.entity.User user = userService.findById(username);	
		if (user == null) {
			 throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetail(user);
	}
/*
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		io.javabrains.springsecurityjwt.entity.User user = userRepository.findById(username);
	     if ( user == null) {
	            throw new UsernameNotFoundException(username);
	        }
	        return new CustomUserDetail(user);
	}
	*/
}