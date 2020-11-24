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
	
	Iterable<User> findAll(){
		return user.findAll();
	}

	User findById(String id) {
		return user.findById(id).get();
	}

	void delete(User userDelete) {
		user.delete(userDelete);
	}
	
	void deleteById(String id) {
		user.deleteById(id);
	}
	
	void save(User userSave) {
		user.save(userSave);
	}
	
	void saveAll(Iterable<User> users) {
		user.saveAll(users); 
	}
	

}
