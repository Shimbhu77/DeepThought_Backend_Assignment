package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/app/create-user")
	public ResponseEntity<User>  createUserHandler(@RequestBody User user)
	{
		User newUser  = userService.createUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/app/users/{id}")
	public ResponseEntity<User>  getUserHandler(@PathVariable("id") Integer id)
	{
		User newUser  = userService.getUser(id);
		
		return new ResponseEntity<User>(newUser,HttpStatus.OK);
		
	}
	
	@PutMapping("/app/users")
	public ResponseEntity<User>  updateUserHandler(@RequestBody User user)
	{
		User newUser  = userService.updateUser(user);
		
		return new ResponseEntity<User>(newUser,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/app/users/delete/{id}")
	public ResponseEntity<String>  deleteUserHandler(@PathVariable("id") Integer id)
	{
		String newUser  = userService.deleteUser(id);
		
		return new ResponseEntity<String>(newUser,HttpStatus.ACCEPTED);
		
	}
	
	
 }
