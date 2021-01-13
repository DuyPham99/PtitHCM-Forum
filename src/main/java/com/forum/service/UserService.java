package com.forum.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.forum.entity.Post;
import com.forum.entity.User;
import com.forum.respository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepossitory;
	
	public Iterable<User> findAll(){
		return userRepossitory.findAll();
	}

	public User findById(String id) {
		return userRepossitory.findById(id).get();
	}

	public void delete(User userDelete) {
		userRepossitory.delete(userDelete);
	}
	
	public void deleteById(String id) {
		userRepossitory.deleteById(id);
	}
	
	public void save(User userSave) {
		userRepossitory.save(userSave);
	}
	
	public void saveAll(Iterable<User> users) {
		userRepossitory.saveAll(users); 
	}
	
	public String encrypPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodePassword = encoder.encode(password);
		return encodePassword;
	}
	
	public int isValidAccount(User user) {
		if(userRepossitory.searchUser(user.getUsername()) != null)
		{
			return 1;
		} else 
		if(userRepossitory.searchEmail(user.getEmail()) != null)
		{
			return 2;
		}
		return 0;
	}
	
	public List<User> getPageUser(int page){
		Pageable pageable = PageRequest.of(page - 1, 5, Sort.by("username"));
		Page<User> list =  userRepossitory.getAll(pageable);
		 if(list.hasContent()) {
	            return  list.getContent();
	        } else {
	            return new ArrayList<User>();
	       }
	}
}
