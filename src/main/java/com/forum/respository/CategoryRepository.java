package com.forum.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forum.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
