package com.BDD.blue_whale.entities;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="faostat", types={com.BDD.blue_whale.entities.Faostat.class})
public interface ProjectionFaostat {
	
	@Value("#{target.id}")
	public Long getId();
	public int getYear();
	public int getArea_harvested();
	public String getUnit_area();
	public int getYield();
	public String getUnit_yield();
	public int getProduction();
	public String getUnit_production();
	public Date getDate_modif();
	public Product getProduct();
	public Country getCountry();
	public Source getSource();
	
}
