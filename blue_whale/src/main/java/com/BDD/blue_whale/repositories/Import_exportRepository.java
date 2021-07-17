package com.BDD.blue_whale.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.BDD.blue_whale.entities.Import_export;

@RepositoryRestResource
public interface Import_exportRepository extends JpaRepository<Import_export, Long>{

	/*List<Import_export> findByCountry_country_exporter_id(long country_exporter_id);

	List<Import_export> findByCountry_country_importer_id(long country_importer_id);

	List<Import_export> findByProduct_product_id(long product_id);*/

}
