package com.BDD.blue_whale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.BDD.blue_whale.entities.Country_translation;

@RepositoryRestResource
public interface Country_translationRepository extends JpaRepository<Country_translation, Long>{

	/*public List<Country_translation> findBycountry_id(long country_id);*/
	
}
