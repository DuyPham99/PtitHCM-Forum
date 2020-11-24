package com.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.entity.Comment;
import com.forum.entity.Post;
import com.forum.entity.User;
import com.forum.respository.PostRepository;
import com.forum.respository.UserRepository;

@Service
public class PostService {
	@Autowired
	PostRepository post;
	
	Iterable<Post> findAll(){
		return post.findAll();
	}

	Post findById(String id) {
		return post.findById(id).get();
	}

	void delete(Post userDelete) {
		post.delete(userDelete);
	}
	
	void deleteById(String id) {
		post.deleteById(id);
	}
	
	void save(Post postSave) {
		post.save(postSave);
	}
	
	void saveAll(Iterable<Post> posts) {
		post.saveAll(posts); 
	}
}
