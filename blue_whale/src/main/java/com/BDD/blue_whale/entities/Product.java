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
@Table(name="product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long product_id;
	private Integer product_iso;
	private String product_name;
	
	@OneToMany(mappedBy="product")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Product_translation> product_translation;
	@OneToMany(mappedBy="product")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Faostat> faostat;
	@OneToMany(mappedBy="product")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Import_export> import_export;
	@OneToMany(mappedBy="product")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Variety> variety;
}
