package com.BDD.blue_whale.entities;

import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Excel {
	
	private String tradeflow;
	private String country_expo;
	private String country_impo;
	private String product;
	private String variety;
	private String years;
	private String months;
	private String value;
	private String unit_value;
	private String netweight;
	private String unit_netweight;
	private String source;
}
