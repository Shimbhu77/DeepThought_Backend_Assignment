package com.app.service;

import com.app.model.User;

public interface UserService {

	public User createUser(User user);
	public User getUser(Integer id);
	public User updateUser(User user);
	public String deleteUser(Integer id);
	
}
