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
@Table(name="source")
public class Source implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long source_id;
	private String source_name;
	private String source_url;
	
	@OneToMany(mappedBy="source")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Import_export> import_export;
	
	@OneToMany(mappedBy="source")
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<Faostat> faostat;
}
