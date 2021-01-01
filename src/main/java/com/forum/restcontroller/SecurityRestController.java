package com.forum.restcontroller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.forum.entity.User;
import com.forum.security.AuthenticationRequest;
import com.forum.service.UserService;

@RestController
public class SecurityRestController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private com.forum.security.JwtUtil jwtTokenUtil;

	@Autowired
	private com.forum.security.MyUserDetailsService userDetailsService;	
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest request) throws Exception {		
		try {
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			// check user/pass from DB
			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			
			// add to session and model when login finish
			request.getSession().setAttribute("username", userDetails.getUsername());
			return  ResponseEntity.ok(new com.forum.security.AuthenticationResponse(jwt));
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
	}
	
	@GetMapping("/create/hello")
	public String sayHello() {
		return "hello";
	}
	
}
