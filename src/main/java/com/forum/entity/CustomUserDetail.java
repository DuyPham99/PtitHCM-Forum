package com.forum.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
public class CustomUserDetail implements UserDetails{
	
	User user;
	
	public CustomUserDetail() {

	}
	
	public CustomUserDetail(User user) {
		super();
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	 @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        // Mặc định mình sẽ để tất cả là ROLE_USER. Để demo cho đơn giản.
	        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
	    }

	    @Override
	    public String getPassword() {
	        return user.getPassword();
	    }

	    @Override
	    public String getUsername() {
	        return user.getUsername();
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

}
