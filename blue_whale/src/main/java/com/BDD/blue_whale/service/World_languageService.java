package com.BDD.blue_whale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.World_language;

@Service
public interface World_languageService {
	
	public void addWorld_language(World_language world_language);
	
	public List<World_language> listWorld_language();
	
	public Optional<World_language> getWorld_languageById(String alpha2);
	
	public void deleteWorld_language(String alpha2);
	
	public void updateWorld_language(World_language world_language);


}
