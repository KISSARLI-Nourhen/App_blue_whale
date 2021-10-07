package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Source;
import com.BDD.blue_whale.repositories.SourceRepository;

@Service
@Transactional
public class SourceServiceImpl implements SourceService{
	
	@Autowired
	private SourceRepository SourceRepository;
	
	@Override
	public void addSource(Source source) {
		
		SourceRepository.save(source);
	}

	@Override
	public List<Source> listSource() {
		
		return SourceRepository.findAll();
	}

	@Override
	public Optional<Source> getSourceById(long source_id) {
		
		return SourceRepository.findById(source_id);
	}

	@Override
	public void deleteSource(long source_id) {
		
		SourceRepository.deleteById(source_id);
	}

	@Override
	public void updateSource(Source source) {
		SourceRepository.save(source);
		
	}

	

}
