package com.BDD.blue_whale.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.BDD.blue_whale.entities.Country;
import com.BDD.blue_whale.entities.Faostat;

@RepositoryRestResource
@CrossOrigin("*")
public interface FaostatRepository extends JpaRepository<Faostat, Long>{

	/*List<Faostat> findByCountry(long country_id);

	List<Faostat> findByProduct(long product_id);*/
	
	Page<Faostat> findByCountry(Country country, Pageable pageable);
	
}
