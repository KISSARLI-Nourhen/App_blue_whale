package com.BDD.blue_whale.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.BDD.blue_whale.entities.User;

@RepositoryRestResource
@CrossOrigin("*")
public interface UserRepository extends JpaRepository<User, Long>{
	//User findByUsername(String lastName);
	//Boolean existsByLastName(String lastName);
	
	Optional<User> findByEmail(String email);
	Boolean existsByEmail(String email);
}
