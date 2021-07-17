package com.BDD.blue_whale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.BDD.blue_whale.entities.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{
	User findByLastName(String lastName);
	User findByEmail(String email);
}
