package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.Country_translation;
import com.BDD.blue_whale.repositories.Country_translationRepository;

@Service
@Transactional
public class Country_translationServiceImpl implements Country_translationService{

	@Autowired
	private Country_translationRepository country_translationRepository;
	
	
	@Override
	public void addCountry_translation(Country_translation country_translation) {
		
		country_translationRepository.save(country_translation);
	}

	@Override
	public List<Country_translation> listCountry_translation() {
		
		return country_translationRepository.findAll();
	}

	@Override
	public Optional<Country_translation> getCountry_TranslationById(long country_translation_id) {
		
		return country_translationRepository.findById(country_translation_id);
	}

	
	@Override
	public void deleteCountry_translation(long country_translation_id) {
		
		country_translationRepository.deleteById(country_translation_id);
		
	}

	@Override
	public void updateCountry_translation(Country_translation country_translation) {
		country_translationRepository.save(country_translation);
		
	}
	
	

	
}
