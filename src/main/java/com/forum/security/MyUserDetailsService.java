package com.forum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.forum.entity.User;
import com.forum.service.UserService;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;
	
	User user;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub	
		user = userService.findById(username);	
		if (user == null) {
			 throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetail(user);
	}
	
//	public int getAuthorize(String ) {
//		
//		return 0;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}