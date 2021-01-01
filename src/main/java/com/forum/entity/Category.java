package com.forum.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

import com.sun.istack.NotNull;

@Entity
public class Category {
	@Id
	@NotNull
	int idCategory;
	
	@NotNull
	String name;
	
	public Category() {
	}
	
	public Category(int idCategory, String name) {
		super();
		this.idCategory = idCategory;
		this.name = name;
	}
	
	public Category(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public Category(String idCategory) {
		this.idCategory = Integer.parseInt(idCategory);
	}
	
	public int getIdCategory() {
		return idCategory;
	}
	
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
