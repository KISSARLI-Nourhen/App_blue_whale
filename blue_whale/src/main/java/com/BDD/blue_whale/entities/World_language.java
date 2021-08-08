package com.BDD.blue_whale.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private java.lang.String alpha2;
	private String langen;
	private String langfr;
	
	
	@OneToMany(mappedBy="world_language")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Product_translation> product_translation;
	
	@OneToMany(mappedBy="world_language")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Country_translation> country_translation;
	
	
	
	
}
