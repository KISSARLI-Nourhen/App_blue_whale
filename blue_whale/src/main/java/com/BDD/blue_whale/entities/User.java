package com.BDD.blue_whale.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name="users")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(nullable =false)
	private String firstName;
	
	@Column(nullable =false)
	private String lastName;
	
	@Column(nullable =false)
	private String passwords;
	
	@Column(unique=true)
	private String email;
	private Boolean active;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
	private Collection<Role> role = new ArrayList<>();
}
