package com.forum.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forum.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
}
