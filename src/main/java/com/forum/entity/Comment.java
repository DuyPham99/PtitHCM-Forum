package com.forum.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@NotNull
	@Column(name = "id_comment")
	String idComment;
	@NotNull
	String content;
	String reply;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:MM:ss")
	@Column(name = "date")
	Date dateCreate;

	@ManyToOne
	@JoinColumn(name = "username")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "id_post")
	Post post;

	public Comment() {
		super();
	}

	public Comment(String idComment, String content, String reply, Date dateCreate, User user, Post post) {
		super();
		this.idComment = idComment;
		this.content = content;
		this.reply = reply;
		this.dateCreate = dateCreate;
		this.user = user;
		this.post = post;
	}

	@Override
	public String toString() {
		return "Comment [idComment=" + idComment + ", content=" + content + ", reply=" + reply + ", dateCreate="
				+ dateCreate + ", user=" + user + ", post=" + post + "]";
	}

	public String getIdComment() {
		return idComment;
	}

	public void setIdComment(String idComment) {
		this.idComment = idComment;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	

}
