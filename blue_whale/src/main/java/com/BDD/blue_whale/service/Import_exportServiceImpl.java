package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Import_export;
import com.BDD.blue_whale.repositories.Import_exportRepository;

@Service
@Transactional
public class Import_exportServiceImpl implements Import_exportService{

	@Autowired
	private Import_exportRepository Import_exportRepository;
	
	
	@Override
	public void addImport_export(Import_export import_export) {
		Import_exportRepository.save(import_export);
		
	}

	@Override
	public List<Import_export> listImport_export() {
		
		return Import_exportRepository.findAll();
	}

	@Override
	public Optional<Import_export> getImport_exportById(long id) {
		
		return Import_exportRepository.findById(null);
	}

	@Override
	public void deleteImport_export(long id) {
		Import_exportRepository.deleteById(id);
		
	}

	@Override
	public void updateImport_export(Import_export import_export) {
		Import_exportRepository.save(import_export);
		
	}

	

	
	

}
