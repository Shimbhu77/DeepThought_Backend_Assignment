package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mapper.UserMapper;
import com.app.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User createUser(User user) {
		
		userMapper.insertUser(user);
		
		return user;
	}

	@Override
	public User getUser(Integer id) {
		
		return userMapper.selectUserById(id);
	}

	@Override
	public User updateUser(User user) {
		
		userMapper.updateUser(user);
		
		return user;
		
	}

	@Override
	public String deleteUser(Integer id) {
		
		userMapper.deleteUser(id);
		
		return "user deleted successfully.";
	}
	
	
	
}
