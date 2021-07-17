package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Country;

@Service
public interface CountryService {
	
	public void addCountry(Country country);
	
	public List<Country> listCountry();
	
	public Optional<Country> getCountryById(long country_id);
	
	public void deleteCountry(long country_id);
	
	public void updateCountry(Country country);
}
