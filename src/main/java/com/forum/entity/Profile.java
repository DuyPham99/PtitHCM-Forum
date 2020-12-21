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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "profile")
public class Profile {
	@Id
	@NotNull
	String username;
	String avatar;
	String name;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date birthday;
	Boolean gender;
	@Column(name = "identity_card")
	String idCard;

	@Column(name = "phone_number")
	String phoneNumber;

	String address;
	
	@OneToOne
	@JoinColumn(name = "username")
	@NotNull
	User user;

	public Profile() {
		super();
	}

	
	public Profile(String username, String avatar, String name, Date birthday, Boolean gender, String idCard,
			String phoneNumber, String address, User user) {
		super();
		this.username = username;
		this.avatar = avatar;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.idCard = idCard;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.user = user;
	}


	@Override
	public String toString() {
		return "Profile [username=" + username + ", avatar=" + avatar + ", name=" + name + ", birthday=" + birthday
				+ ", gender=" + gender + ", idCard=" + idCard + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
}
