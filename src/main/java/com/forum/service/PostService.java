package com.forum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public List<Post> getPageElement(Integer pageNo, Integer pageSize, int category){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Post> pagedResult = post.findAll(paging, category);
		
		 if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Post>();
	       }
	}
	
	public List<Post> getPageSortElement(Integer pageNo, Integer pageSize,  String sortBy, int category){
		Pageable paging = PageRequest.of(pageNo, pageSize,  Sort.by(sortBy).descending());
		Page<Post> pagedResult = post.findAll(paging, category);
		
		 if(pagedResult.hasContent()) {
	            return  pagedResult.getContent();
	        } else {
	            return new ArrayList<Post>();
	       }
	}
	
}
