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
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name="import_export")
public class Import_export implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String trade_flow;
	private Integer years;
	private String months;
	private Float value;
	private String unit_value;
	private Float netweight;
	private String unit_netweight;
	private Timestamp date_modif;
	
	@ManyToOne
	//@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="country_exporter_id")
	private Country country_expo;
	
	@ManyToOne
	//@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="country_importer_id")
	private Country country_impo;
	
	@ManyToOne
	//@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="variety_id")
	private Variety variety;
	
	@ManyToOne
	//@JsonProperty(access=Access.WRITE_ONLY)
	@JoinColumn(name="source_id")
	private Source source;
}
