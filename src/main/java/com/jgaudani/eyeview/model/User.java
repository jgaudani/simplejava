package com.jgaudani.eyeview.model;

import java.util.Date;

public class User {
	
	int id;
	
	String name;
	
	int age;
	
	Date createdDate;
	
	public User(int id, String name, int age, Date createdDate) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.createdDate = createdDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
