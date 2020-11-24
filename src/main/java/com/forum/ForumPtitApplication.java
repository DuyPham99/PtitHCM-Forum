package com.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 
@SpringBootApplication
@ComponentScan("com.forum")
public class ForumPtitApplication extends SpringBootServletInitializer {
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ForumPtitApplication.class);
    }
 
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ForumPtitApplication.class, args);
    }
    
    @RestController
    class HelloWorldController {

    	@Autowired
    	private AuthenticationManager authenticationManager;

    	@Autowired
    	private com.forum.security.JwtUtil jwtTokenUtil;

    	@Autowired
    	private com.forum.service.MyUserDetailsService userDetailsService;

    	@RequestMapping({ "/hello" })
    	public String firstPage() {
    		return "Hello World";
    	}

    	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    	public ResponseEntity<?> createAuthenticationToken(@RequestBody com.forum.entity.AuthenticationRequest authenticationRequest) throws Exception {

    		try {
    			authenticationManager.authenticate(
    					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
    			);
    		}
    		catch (BadCredentialsException e) {
    			throw new Exception("Incorrect username or password", e);
    		}


    		final UserDetails userDetails = userDetailsService
    				.loadUserByUsername(authenticationRequest.getUsername());
            System.out.println(userDetails.getUsername());
    		final String jwt = jwtTokenUtil.generateToken(userDetails);

    		return ResponseEntity.ok(new com.forum.entity.AuthenticationResponse(jwt));
    	}

    }
}