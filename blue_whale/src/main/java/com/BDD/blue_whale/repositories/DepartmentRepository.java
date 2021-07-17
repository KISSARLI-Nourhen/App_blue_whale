package com.BDD.blue_whale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.BDD.blue_whale.entities.Department;

@RepositoryRestResource
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
