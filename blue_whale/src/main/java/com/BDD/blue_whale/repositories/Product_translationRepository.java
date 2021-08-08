package com.BDD.blue_whale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.BDD.blue_whale.entities.Product_translation;

@RepositoryRestResource
@CrossOrigin("*")
public interface Product_translationRepository extends JpaRepository<Product_translation, Long>{

	/*List<Product_translation> findByProduct_product_id(long product_id);*/

}
