package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Faostat;

@Service
public interface FaostatService {
	
	public void addFaostat(Faostat faostat);
	
	public List<Faostat> listFaostat();
	
	public Optional<Faostat> getFaostatById(long id);
	
	public void deleteFaostat(long id);
	
	
	
	public void updateFaostat(Faostat faostat);
}
