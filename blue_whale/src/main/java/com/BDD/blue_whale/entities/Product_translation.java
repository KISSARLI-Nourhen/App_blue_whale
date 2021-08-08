package com.BDD.blue_whale.entities;

import java.io.Serializable;
import java.util.Optional;

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
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name="product_translation")
public class Product_translation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long product_translations_id;
	private String translation;
	
	@ManyToOne
	//@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="product_id")
	private Product product;
	@ManyToOne
	//@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="alpha2")
	private World_language world_language;
	
}
