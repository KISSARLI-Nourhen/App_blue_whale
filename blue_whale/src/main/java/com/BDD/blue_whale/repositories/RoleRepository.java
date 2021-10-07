package com.BDD.blue_whale.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.BDD.blue_whale.entities.ERole;
import com.BDD.blue_whale.entities.Role;

@RepositoryRestResource
@CrossOrigin("*")
public interface RoleRepository extends JpaRepository<Role, Long>{
	//Role findByRole(String roleName);
	
	Optional<Role> findByName(ERole name);
}
