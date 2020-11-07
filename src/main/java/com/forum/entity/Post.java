package com.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Post")
public class Post {

	@Id
	@Column(name = "id_post")
	String idPost;
	String content;
	int react;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:MM:ss")
	@Column(name = "date")
	Date timeCreate;

	@OneToOne
	@JoinColumn(name = "username")
	User user;

	public Post() {
		super();
	}

	public Post(String idPost, String content, int react, Date timeCreate, User user) {
		super();
		this.idPost = idPost;
		this.content = content;
		this.react = react;
		this.timeCreate = timeCreate;
		this.user = user;
	}

	public String getIdPost() {
		return idPost;
	}

	public void setIdPost(String idPost) {
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

	@Override
	public String toString() {
		return "Post [idPost=" + idPost + ", content=" + content + ", react=" + react + ", timeCreate=" + timeCreate
				+ ", user=" + user + "]";
	}

}
