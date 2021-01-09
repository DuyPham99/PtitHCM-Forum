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
	
	public Iterable<Profile> findAll(){
		return profile.findAll();
	}

	public com.forum.entity.Profile findById(String id) {
		return profile.findById(id).get();
	}

	public void delete(Profile userDelete) {
		profile.delete(userDelete);
	}
	
	public void deleteById(String id) {
		profile.deleteById(id);
	}
	
	public void save(Profile profileSave) {
		profile.save(profileSave);
	}
	
	public void saveAll(Iterable<Profile> profiles) {
		profile.saveAll(profiles); 
	}
}
