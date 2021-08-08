package com.BDD.blue_whale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.BDD.blue_whale.entities.Faostat;

@RepositoryRestResource
@CrossOrigin("*")
public interface FaostatRepository extends JpaRepository<Faostat, Long>{

	/*List<Faostat> findByCountry_country_id(long country_id);

	List<Faostat> findByProduct_product_id(long product_id);*/
	
}
