package com.BDD.blue_whale.config;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.BDD.blue_whale.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	
	private Long user_id;
	
	private String first_name;
	
	private String last_name;
	
	@JsonIgnore
	private String passwords;
	
	private String email;
	
	private Boolean active; 
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDetailsImpl(Long user_id, String firstName, String lastName, String email, String password,Boolean active,
			Collection<? extends GrantedAuthority> authorities) {
		this.user_id = user_id;
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
		this.passwords = password;
		this.active = active;
		this.authorities = authorities;
	}
	
	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRole().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getUser_id(), 
				user.getFirst_name(),
				user.getLast_name(), 
				user.getEmail(),
				user.getPasswords(),
				user.getActive(),
				authorities);
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return passwords;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(user_id, user.user_id);
	}

}
