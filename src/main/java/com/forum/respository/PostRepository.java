package com.forum.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forum.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, String>{

}
