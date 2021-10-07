package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.BDD.blue_whale.entities.Department;
import com.BDD.blue_whale.repositories.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	
	@Override
	public void addDepartment(Department department) {
		
		departmentRepository.save(department);		
	}

	@Override
	public List<Department> listDepartment() {
		
		return departmentRepository.findAll();
	}

	@Override
	public Optional<Department> getDepartmentById(long department_id) {
		
		return departmentRepository.findById(department_id);
	}

	@Override
	public void deleteDepartment(long department_id) {
		
		departmentRepository.deleteById(department_id);
		
	}

	@Override
	public void updateDepartment(Department department) {
		departmentRepository.save(department);	
		
	}

	


	

}
