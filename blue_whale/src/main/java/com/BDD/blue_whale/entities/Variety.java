package com.BDD.blue_whale.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name="variety")
public class Variety implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long variety_id;
	private String variety_name;
	
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="product_id")
	private Product product;
	@OneToMany(mappedBy="variety")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Import_export> import_export;
	
	
	
}
