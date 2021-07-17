package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Faostat;
import com.BDD.blue_whale.repositories.FaostatRepository;

@Service
@Transactional
public class FaostatServiceImpl implements FaostatService{

	@Autowired
	private FaostatRepository faostatRepository;
	
	@Override
	public void addFaostat(Faostat faostat) {
		
		faostatRepository.save(faostat);
	}

	@Override
	public List<Faostat> listFaostat() {
		
		return faostatRepository.findAll();
	}

	@Override
	public Optional<Faostat> getFaostatById(long id) {
		
		return faostatRepository.findById(id);
	}

	@Override
	public void deleteFaostat(long id) {
		
		faostatRepository.deleteById(id);
	}

	@Override
	public void updateFaostat(Faostat faostat) {
		faostatRepository.save(faostat);
		
	}

/*	@Override
	public List<Faostat> findByCountry(long country_id) {
		
		return faostatRepository.findByCountry_country_id(country_id);
	}*/

	/*@Override
	public List<Faostat> findByProduct(long product_id) {
		
		return faostatRepository.findByProduct_product_id(product_id);
	}*/

}
