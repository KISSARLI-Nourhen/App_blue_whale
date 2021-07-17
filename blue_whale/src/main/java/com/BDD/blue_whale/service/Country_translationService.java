package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Country_translation;

@Service
public interface Country_translationService {
	
	public void addCountry_translation(Country_translation country_translation);
	
	public List<Country_translation> listCountry_translation();
	
	public Optional<Country_translation> getCountry_TranslationById(long country_translation_id);
	
	/*public List<Country_translation> findByCountry(long country_id);*/
	
	public void deleteCountry_translation(long country_translation_id);
	
	public void updateCountry_translation(Country_translation country_translation);
}
