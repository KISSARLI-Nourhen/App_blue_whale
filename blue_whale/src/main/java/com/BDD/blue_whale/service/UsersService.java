package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import com.BDD.blue_whale.entities.Department;
import com.BDD.blue_whale.entities.Role;
import com.BDD.blue_whale.entities.User;

public interface UsersService {
	
	public User addUser(User user);
	public List<User> listUsers();
	public Optional<User> getUserById(long user_id);
	public void updateUser(User user);
	public void deleteUser(long user_id);
	
	
	
	
	
	
	
}
