package com.forum.respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forum.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	@Query(value = "SELECT email FROM user u WHERE u.email = ?1", nativeQuery = true)
	public String searchEmail(String email);
	
	@Query(value = "SELECT username FROM user u WHERE u.username = ?1", nativeQuery = true)
	public String searchUser(String username);
}
