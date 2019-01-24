package com.jgaudani.eyeview.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.jgaudani.eyeview.model.User;
import com.jgaudani.eyeview.service.UserService;

@RestController
@RequestMapping("/eyeview/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>> (userService.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		return new ResponseEntity<User> (userService.getUserById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User u = userService.addUser(user);
		if (u == null) {
			return new ResponseEntity<User>(u, HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<User>(u, HttpStatus.CREATED);
		}
        
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		
		HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user, UriComponentsBuilder ucBuilder) {
		User u = userService.updateUser(id, user);
        return new ResponseEntity<User>(u, HttpStatus.OK);
	}

}
