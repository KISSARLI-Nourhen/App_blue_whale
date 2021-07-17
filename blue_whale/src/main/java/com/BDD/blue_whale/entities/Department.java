package com.BDD.blue_whale.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Department {
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long department_id;
	@Column(unique = true)
	private String department_name;
	
	@OneToMany(mappedBy="department",fetch=FetchType.EAGER)
	@JsonProperty(access=Access.WRITE_ONLY)
	private Collection<User> users;
}
