package com.BDD.blue_whale.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Department;
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
	@Autowired
	private DepartmentRepository departmentRepository;
	/*@Autowired
	private PasswordEncryptUtil passwordEncryptUtil;*/
	
	
	@Override
	public User saveUser(User user) {
		user.setActive(true);
		
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}

	@Override
	public void addUsersToRole(String lastName, String roleName) {
		Role role=roleRepository.findByRole(roleName);
		User users=userRepository.findByLastName(lastName);
		role.getUsers().add(users);
		
	}

	@Override
	public User findByLastName(String lastName) {
		
		return userRepository.findByLastName((new 
				StringBuilder()).append("%").append(lastName).append("%").toString());
	}

	@Override
	public User findByEmail(String email) {

		return userRepository.findByEmail((new 
				StringBuilder()).append("%").append(email).append("%").toString());
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void updateRole(Role role) {
		roleRepository.save(role);
		
	}

	@Override
	public void updateDepartment(Department department) {
		departmentRepository.save(department);
		
	}




}
