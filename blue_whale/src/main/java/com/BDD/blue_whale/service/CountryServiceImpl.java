package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Country;
import com.BDD.blue_whale.repositories.CountryRepository;

@Service
@Transactional
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository countryRepository;
	
	
	@Override
	public void addCountry(Country country) {
		
		countryRepository.save(country);		
	}

	@Override
	public List<Country> listCountry() {
		
		return countryRepository.findAll();
	}

	@Override
	public Optional<Country> getCountryById(long country_id) {
		
		return countryRepository.findById(country_id);
	}

	@Override
	public void deleteCountry(long country_id) {
		
		countryRepository.deleteById(country_id);
		
	}

	@Override
	public void updateCountry(Country country) {
		countryRepository.save(country);		
	}
	
	
}
