package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import com.BDD.blue_whale.entities.Role;
import com.BDD.blue_whale.entities.User;
import com.BDD.blue_whale.repositories.DepartmentRepository;
import com.BDD.blue_whale.repositories.RoleRepository;
import com.BDD.blue_whale.repositories.UserRepository;


@Service
@Transactional
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	
	
	@Override
	public User addUser(User user) {
		user.setActive(true);
		return userRepository.save(user);
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}
	
	@Override
	public void deleteUser(long user_id) {
		userRepository.deleteById(user_id);
	}
	
	@Override
	public List<User> listUsers() {
		return userRepository.findAll();
	}

	
	@Override
	public Optional<User> getUserById(long user_id) {
		return userRepository.findById(user_id);
	}
	
	


	

	



}
