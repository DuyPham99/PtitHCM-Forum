package com.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
	
	public Iterable<Post> findAll(){
		return post.findAll();
	}
	
	public Post findById(int id) {
		return post.findById(id).get();
	}

	public void delete(Post userDelete) {
		post.delete(userDelete);
	}
	
	public void deleteById(int id) {
		post.deleteById(id);
	}
	
	public void save(Post postSave) {
		post.save(postSave);
	}
	
	public void saveAll(Iterable<Post> posts) {
		post.saveAll(posts); 
	}
	
}
