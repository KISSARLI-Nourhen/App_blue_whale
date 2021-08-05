package com.BDD.blue_whale.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;


@Projection(name="pt", types={com.BDD.blue_whale.entities.Product_translation.class})
public interface ProjectionProductTranslation {
	
	@Value("#{target.product_translations_id}")
	public Long getProduct_translations_id();
	public String getTranslation();
	public Product getProduct();
	public World_language getWorld_language(); 
}
