package com.BDD.blue_whale.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Role;
import com.BDD.blue_whale.repositories.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}
	
	@Override
	public void updateRole(Role role) {
		roleRepository.save(role);
		
	}
	
	@Override
	public void deleteRole(long role_id) {
		roleRepository.deleteById(role_id);
	}
	
	@Override
	public List<Role> listRoles() {
		return roleRepository.findAll();
	}

}
