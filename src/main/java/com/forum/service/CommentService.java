package com.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.entity.Comment;
import com.forum.entity.Post;
import com.forum.entity.User;
import com.forum.respository.CommentRepository;
import com.forum.respository.PostRepository;

@Service
public class CommentService {
	@Autowired
	CommentRepository comment;
	
	Iterable<Comment> findAll(){
		return comment.findAll();
	}

	Comment findById(String id) {
		return comment.findById(id).get();
	}

	void delete(Comment userDelete) {
		comment.delete(userDelete);
	}
	
	void deleteById(String id) {
		comment.deleteById(id);
	}
	
	void save(Comment commentSave) {
		comment.save(commentSave);
	}
	
	void saveAll(Iterable<Comment> comments) {
		comment.saveAll(comments); 
	}
}
