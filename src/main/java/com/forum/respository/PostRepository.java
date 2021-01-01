package com.forum.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forum.entity.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
	@Query(value = "SELECT * FROM forum.post\r\n"
			+ "WHERE username= ?1\r\n"
			+ "ORDER BY id_post DESC\r\n"
			+ "LIMIT 1;", nativeQuery = true)
	public Post getLastPostOfUser(String username);
}
