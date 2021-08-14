package com.BDD.blue_whale.entities;

import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="ImpoExpo", types={com.BDD.blue_whale.entities.Import_export.class})
public interface ProjectionImport_export {
	
	@Value("#{target.id}")
	public Long getId();
	public String getTrade_flow();
	public Integer getYears();
	public String getMonths();
	public Float getValue();
	public String getUnit_value();
	public Float getNetweight();
	public String getUnit_netweight();
	public Timestamp getDate_modif();
	public Country getCountry_expo();
	public Country getCountry_impo();
	public Product getProduct();
	public Variety getVariety();
	public  Source getSource();
	
}
