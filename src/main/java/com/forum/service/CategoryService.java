package com.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.entity.Category;
import com.forum.respository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository category;
	
	public Category findById(int id) {
		return category.findById(id).get();
	}
}
