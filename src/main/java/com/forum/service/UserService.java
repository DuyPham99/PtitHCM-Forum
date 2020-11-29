package com.forum.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.entity.User;
import com.forum.respository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository user;
	
	public Iterable<User> findAll(){
		return user.findAll();
	}

	public User findById(String id) {
		return user.findById(id).get();
	}

	public void delete(User userDelete) {
		user.delete(userDelete);
	}
	
	public void deleteById(String id) {
		user.deleteById(id);
	}
	
	public void save(User userSave) {
		user.save(userSave);
	}
	
	public void saveAll(Iterable<User> users) {
		user.saveAll(users); 
	}
	
}
