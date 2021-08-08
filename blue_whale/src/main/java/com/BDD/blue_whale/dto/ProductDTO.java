package com.BDD.blue_whale.dto;

import java.util.Collection;

import javax.persistence.OneToMany;

import com.BDD.blue_whale.entities.Faostat;
import com.BDD.blue_whale.entities.Import_export;
import com.BDD.blue_whale.entities.Product_translation;
import com.BDD.blue_whale.entities.Variety;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ProductDTO {
	private int product_id;
	private int product_iso;
	private String product_name;
	
}
