package com.forum.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
public class User {
	@Id
	@NotNull(message = "Username không bỏ trống!")
	@NotBlank(message = "Username không chứa khoảng trắng")
	@Size(min = 2, max = 20, message = "Độ dài Username từ 2 đến 20 ký tự!")
	String username;
	
	@Email(message = "Email không hợp lệ!")
	@NotNull
	String email;
	
	@NotNull
	String password;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	Profile profile;
	
	@OneToMany(mappedBy = "user")
	List<Post> posts;
	
	@OneToMany(mappedBy = "user")
	List<Comment> comments;
		
	public User() {
		super();
	}
	
	public User(String username, String email, String password, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
