package com.forum.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forum.entity.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, String>{

}
