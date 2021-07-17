package com.BDD.blue_whale.service;

import com.BDD.blue_whale.entities.Country;
import com.BDD.blue_whale.entities.Department;
import com.BDD.blue_whale.entities.Role;
import com.BDD.blue_whale.entities.User;

public interface UsersService {
	
	public User saveUser(User user);
	
	public User findByEmail(String email);
	
	public Role saveRole(Role role);
	
	public Department saveDepartment(Department department);
	
	public void addUsersToRole(String userName, String roleName);
	
	public User findByLastName(String userName);
	
	public void updateUser(User user);
	
	public void updateRole(Role role);
	
	public void updateDepartment(Department department);
	
}
