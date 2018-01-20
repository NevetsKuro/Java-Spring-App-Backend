package com.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@SuppressWarnings("deprecation")
@Entity
@Component
public class User implements Serializable{
	/**
	 * implement hibernate validiation
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	String name;
	@NotNull
	@Email(message="Enter a valid Email")
	String email;
	@NotNull
	String place;
	@NotNull
	@Length(min=6,message="Password should contain atleast 6 characters")
	String password;
	String gender;
	String role;
	Boolean enabled;
	
	public User() {
		
	}

	public User(String name, String email, String place, String password, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.place = place;
		this.password = password;
		this.gender =gender;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", place=" + place + ", password=" + password + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
