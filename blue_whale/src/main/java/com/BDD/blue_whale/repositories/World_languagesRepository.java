package com.BDD.blue_whale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.BDD.blue_whale.entities.World_language;

@RepositoryRestResource
public interface World_languagesRepository extends JpaRepository<World_language, java.lang.String>{
	
}
