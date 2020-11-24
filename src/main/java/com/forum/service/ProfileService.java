package com.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.entity.Comment;
import com.forum.entity.Post;
import com.forum.entity.Profile;
import com.forum.respository.CommentRepository;
import com.forum.respository.ProfileRepository;

@Service
public class ProfileService {
	@Autowired
	ProfileRepository profile;
	
	Iterable<Profile> findAll(){
		return profile.findAll();
	}

	com.forum.entity.Profile findById(String id) {
		return profile.findById(id).get();
	}

	void delete(Profile userDelete) {
		profile.delete(userDelete);
	}
	
	void deleteById(String id) {
		profile.deleteById(id);
	}
	
	void save(Profile profileSave) {
		profile.save(profileSave);
	}
	
	void saveAll(Iterable<Profile> profiles) {
		profile.saveAll(profiles); 
	}
}
