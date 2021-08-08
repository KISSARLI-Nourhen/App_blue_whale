package com.BDD.blue_whale.dto;

import com.BDD.blue_whale.entities.World_language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Product_translationDTO {
	private Long product_translations_id;
	private String translation;
	private ProductDTO product;
	private languageDTO world_language;
}
