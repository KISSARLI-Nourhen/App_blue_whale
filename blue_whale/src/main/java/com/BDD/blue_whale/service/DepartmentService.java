package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Department;

@Service
public interface DepartmentService {

public void addDepartment(Department department);
	
	public List<Department> listDepartment();
	
	public Optional<Department> getDepartmentById(long department_id);
	
	public void deleteDepartment(long department_id);
	
	public void updateDepartment(Department department);
}
