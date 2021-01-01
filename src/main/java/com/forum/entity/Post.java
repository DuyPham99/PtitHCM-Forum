package com.forum.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsExclude;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Post")
public class Post {

	@Id
	@Column(name = "id_post")
	@NotNull(message = "Không được bỏ trống!")
	int idPost;
	
	@NotEmpty(message = "Tiêu đề không được bỏ trống!")
	String title;
	
	@NotEmpty(message = "Nội dung không được bỏ trống!")
	String content;
	
	int react;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:MM:ss")
	@Column(name = "date")
	@CreationTimestamp
	Date timeCreate;
	
	@ManyToOne
	@JoinColumn(name = "username")
	User user;
	
	@OneToMany(mappedBy = "post", cascade=CascadeType.ALL)
	List<Comment> comments;
	
	@Column(name = "id_category")
	@Min(value = 1, message = "Chọn danh mục")
	@Max(value = 6, message = "Chọn danh mục")
	int id_category;

	public Post() {
		super();
	}

	public Post(String content, int react, Date timeCreate, User user) {
		super();
		this.content = content;
		this.react = react;
		this.timeCreate = timeCreate;
		this.user = user;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReact() {
		return react;
	}

	public void setReact(int react) {
		this.react = react;
	}

	public Date getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(Date timeCreate) {
		this.timeCreate = timeCreate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getCategory() {
		return id_category;
	}

	public void setCategory(int cotegory) {
		this.id_category = cotegory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Post [idPost=" + idPost + ", content=" + content + ", title=" + title + ", react=" + react
				+ ", timeCreate=" + timeCreate + ", user=" + user + ", comments=" + comments + ", category=" + id_category
				+ "]";
	}

	

}
