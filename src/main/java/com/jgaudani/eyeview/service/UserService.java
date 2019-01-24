package com.jgaudani.eyeview.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jgaudani.eyeview.model.User;

@Service
public class UserService {
	
	
	private static List<User> users = new ArrayList<>();
	private static Integer id = 1;
	
	static {
		users = populateDummyUsers();
	}
	
	public User getUserById(int id) {
		for (User u: users) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User addUser(User user) {
		user.setId(id++);
		user.setCreatedDate(new Date());
		users.add(user);
		return user;
	}
	
	private boolean userExistsWithSameNameAndAge(User user) {
		for (User u: users) {
			if (u.getName().contentEquals(user.getName()) && u.getAge() == user.getAge()) {
				return true;
			}
		}
		return false;
	}
	
	public User updateUser(Integer id, User user) {
		User existingUser = getUserById(id);
		if (existingUser != null) {
			int index = users.indexOf(existingUser);
			users.set(index, user);
			return user;
		}
		return null;
	}
	
	public void deleteUser(Integer id) {
		User u = getUserById(id);
		users.remove(u);
	}
	
	public void deleteAllUsers(){
		users.clear();
	}
	
	private static List<User> populateDummyUsers() {
		users.add(new User(id++, "Peldi", 37, new Date()));
		users.add(new User(id++, "Lior", 34, new Date()));
		users.add(new User(id++, "Patata", 37, new Date()));
		users.add(new User(id++, "Val", 18, new Date()));
		users.add(new User(id++, "Shakshouka", 6, new Date()));
		users.add(new User(id++, "Jachnun", 15, new Date()));
		return users;
	}
}
