package com.BDD.blue_whale.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Table(name="users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "email")
		})
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@NotBlank
	@Column(nullable =false)
	private String first_name;
	
	@NotBlank
	@Column(nullable =false)
	private String last_name;
	
	@NotBlank
	@Column(nullable =false)
	@Size(max = 120)
	private String passwords;
	
	@NotBlank
	@Column(nullable =false)
	@Size(max = 50)
	@Email
	private String email;
	

	private Boolean active;
	
	@ManyToOne
	private Department department;
	
	@ManyToMany(/*mappedBy = "users",*/fetch = FetchType.EAGER)
	@JoinTable (name = "role_users", 
						joinColumns = @JoinColumn(name = "user_id"),
						inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> role = new HashSet<>();
	
	
	
}
