package com.BDD.blue_whale.entities;

import java.io.Serializable;
import java.util.Collection;

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
@Table(name="country")
public class Country implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long country_id;
	private String iso2;
	private String iso3;
	private Integer country_code;
	private String country_name;
	
	@OneToMany(mappedBy="country")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Faostat> faostat;
	
	@OneToMany(mappedBy="country_expo")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Import_export> import_export;
	
	@OneToMany(mappedBy="country_impo")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Import_export> import_export1;
	
	@OneToMany(mappedBy="country")
	private Collection<Country_translation> country_translation;
	
	
}
