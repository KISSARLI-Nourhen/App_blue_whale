package com.BDD.blue_whale.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name="country_translation",schema = "public")
public class Country_translation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long country_translation_id;
	private String translation;
	
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="alpha2")
	private World_language world_language;
	
	
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="country_id")
	private Country country ;
	
	
}
