package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Variety;
import com.BDD.blue_whale.repositories.VarietyRepository;

@Service
@Transactional
public class VarietyServiceImpl implements VarietyService{

	@Autowired
	private VarietyRepository VarietyRepository;
	
	
	@Override
	public void addVariety(Variety variety) {
		
		VarietyRepository.save(variety);
	}

	@Override
	public List<Variety> listVariety() {
		
		return VarietyRepository.findAll();
	}

	@Override
	public Optional<Variety> getVarietyById(long variety_id) {
		
		return VarietyRepository.findById(variety_id);
	}

	@Override
	public void deleteVariety(long variety_id) {
		
		VarietyRepository.deleteById(variety_id);
	}

	@Override
	public void updateVariety(Variety variety) {
		VarietyRepository.save(variety);
		
	}

	
}
