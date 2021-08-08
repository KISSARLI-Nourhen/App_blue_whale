package com.BDD.blue_whale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.BDD.blue_whale.entities.Variety;

@RepositoryRestResource
@CrossOrigin("*")
public interface VarietyRepository extends JpaRepository<Variety, Long>{

	/*List<Variety> findByProduct_product_id(long product_id);*/

}
