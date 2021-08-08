package com.BDD.blue_whale.dto;

import java.util.Collection;

import com.BDD.blue_whale.entities.Country_translation;
import com.BDD.blue_whale.entities.Product_translation;
import com.BDD.blue_whale.entities.World_language;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class languageDTO {
	private java.lang.String alpha2;
	private String langen;
	private String langfr;
}
