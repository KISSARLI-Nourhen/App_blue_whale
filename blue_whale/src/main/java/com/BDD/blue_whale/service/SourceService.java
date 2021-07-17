package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Source;

@Service
public interface SourceService {

	public void addSource(Source source);
	
	public List<Source> listSource();
	
	public Optional<Source> getSourceById(long source_id);
	
	public void deleteSource(long source_id);
	
	public void updateSource(Source source);
	
	/*public Source findByImport_export(long id);
	
	public Source findByFaostat(long id);*/
}
