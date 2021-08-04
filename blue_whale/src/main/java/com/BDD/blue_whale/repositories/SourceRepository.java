package com.BDD.blue_whale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.BDD.blue_whale.entities.Source;

@RepositoryRestResource
@CrossOrigin("*")
public interface SourceRepository extends JpaRepository<Source, Long>{

/*	Source findByImport_export_id(long id);

	Source findByFaostat_id(long id);*/

}
