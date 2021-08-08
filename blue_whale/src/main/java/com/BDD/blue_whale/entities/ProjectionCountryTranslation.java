package com.BDD.blue_whale.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="ct", types={com.BDD.blue_whale.entities.Country_translation.class})
public interface ProjectionCountryTranslation {
	
	@Value("#{target.country_translation_id}")
	public Long getCountry_translation_id();
	public String getTranslation();
	public String getAlpha2_langue();
	public Country getCountry();
	public World_language getWorld_language(); 
}
