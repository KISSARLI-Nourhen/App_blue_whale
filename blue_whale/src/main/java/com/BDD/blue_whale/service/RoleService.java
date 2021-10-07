package com.BDD.blue_whale.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Role;

@Service
public interface RoleService {
	
	public Role addRole(Role role);
	public List<Role> listRoles();
	public void updateRole(Role role);
	public void deleteRole(long role_id);
}
