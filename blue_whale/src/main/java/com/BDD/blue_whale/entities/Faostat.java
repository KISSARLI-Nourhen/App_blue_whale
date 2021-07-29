package com.BDD.blue_whale.entities;

import java.io.Serializable;
import java.security.Timestamp;

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
@Table(name="faostat")
public class Faostat implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private int year;
	private int area_harvested;
	private String unit_area;
	private int yield;
	private String unit_yield;
	private int production;
	private String unit_production;
	private Timestamp date_modif;
	
	@ManyToOne
	//@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="product_id")
	private Product product;
	@ManyToOne
	//@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="country_id")
	private Country country;
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="source_id")
	private Source source;
	
}
