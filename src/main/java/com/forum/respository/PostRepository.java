package com.forum.respository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Query(value = "SELECT * FROM forum.post\r\n"
			+ "WHERE username= ?1\r\n"
			+ "ORDER BY id_post DESC\r\n", nativeQuery = true)
	public List<Post> getPostOfUser(String username);

	@Query(value = "SELECT * FROM forum.post\r\n"
			+ "WHERE id_category = 1\r\n"
			+ "ORDER BY id_post desc\r\n"
			+ "LIMIT 5;", nativeQuery = true)
	public ArrayList<Post> getActivePost();
	
	@Query(value = "SELECT * FROM forum.post\r\n"
			+ "WHERE id_category = 2\r\n"
			+ "ORDER BY id_post desc\r\n"
			+ "LIMIT 5;", nativeQuery = true)
	public ArrayList<Post> getStudyPost();
	
	@Query(value = "SELECT * FROM forum.post\r\n"
			+ "WHERE id_category = 3\r\n"
			+ "ORDER BY id_post desc\r\n"
			+ "LIMIT 5;", nativeQuery = true)
	public ArrayList<Post> getClubPost();
	
	@Query(value = "SELECT * FROM forum.post\r\n"
			+ "WHERE id_category = 4\r\n"
			+ "ORDER BY id_post desc\r\n"
			+ "LIMIT 4;", nativeQuery = true)
	public ArrayList<Post> getTalkPost();
	
	@Query(value = "SELECT * FROM forum.post\r\n"
			+ "WHERE id_category = 5\r\n"
			+ "ORDER BY id_post desc\r\n"
			+ "LIMIT 4;", nativeQuery = true)
	public ArrayList<Post> getExpPost();
	
	@Query(value = "SELECT * FROM forum.post\r\n"
			+ "WHERE id_category = 6\r\n"
			+ "ORDER BY id_post desc\r\n"
			+ "LIMIT 5;", nativeQuery = true)
	public ArrayList<Post> getAnotherPost();
	
	@Query(value = "SELECT * FROM forum.post WHERE id_category = :category", nativeQuery = true)
	Page<Post> findAll(Pageable pageable, int category);
	
	@Query(value="SELECT count(*) FROM forum.post WHERE id_category = :category", nativeQuery = true)
	public int countRecord(int category);
}
