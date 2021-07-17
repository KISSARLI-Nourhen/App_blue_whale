package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.World_language;
import com.BDD.blue_whale.repositories.World_languagesRepository;

@Service
@Transactional
public class World_languageServiceImpl implements World_languageService{

	@Autowired
	private World_languagesRepository world_languagesRepository;
	
	
	@Override
	public void addWorld_language(World_language world_language) {
		world_languagesRepository.save(world_language);
		
	}

	@Override
	public List<World_language> listWorld_language() {
		
		return world_languagesRepository.findAll();
	}

	@Override
	public Optional<World_language> getWorld_languageById(String alpha2) {
		
		return world_languagesRepository.findById(alpha2);
	}

	@Override
	public void deleteWorld_language(String alpha2) {
		
		world_languagesRepository.deleteById(alpha2);
		
	}

	@Override
	public void updateWorld_language(World_language world_language) {
		
		world_languagesRepository.save(world_language);
	}
	
	
}
