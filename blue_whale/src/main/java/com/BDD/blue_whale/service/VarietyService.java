package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Variety;

@Service
public interface VarietyService {

	public void addVariety(Variety variety);
	
	public List<Variety> listVariety();
	
	public Optional<Variety> getVarietyById(long variety_id);
	
	public void deleteVariety(long variety_id);
	
	public void updateVariety(Variety variety);
	
	
}
