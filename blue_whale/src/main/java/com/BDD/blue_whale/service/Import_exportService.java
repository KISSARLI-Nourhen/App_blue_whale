package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Import_export;

@Service
public interface Import_exportService {
	
	public void addImport_export(Import_export import_export);
	
	public List<Import_export> listImport_export();
	
	public Optional<Import_export> getImport_exportById(long id);
	
	public void deleteImport_export(long id);
	
	public void updateImport_export(Import_export import_export);
	
	
	
}
