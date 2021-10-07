package com.BDD.blue_whale.web;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.*;


import com.BDD.blue_whale.entities.Department;

public class SignupRequest {
	
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
	@Column(unique=true)
	@Size(max = 50)
	@Email
	private String email;
	
	private Boolean active;
	
	@ManyToOne
	private Department department;
    
    private Set<String> role;

	public Long getUserId() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String lastName) {
		this.last_name = lastName;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive() {
		this.active = true;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
    
    
    
  
    
}
