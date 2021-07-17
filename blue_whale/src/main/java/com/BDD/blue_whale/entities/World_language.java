package com.BDD.blue_whale.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name="world_language")
public class World_language implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private java.lang.String alpha2;
	private String langen;
	private String langfr;
	
	@OneToMany(mappedBy="world_language")
	private Collection<Product_translation> product_translation;
	
	@OneToMany(mappedBy="world_language")
	private Collection<Country_translation> country_translation;
	
	
	
	
}
