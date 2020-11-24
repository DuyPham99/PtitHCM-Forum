package com.forum.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forum.entity.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, String> {

}
