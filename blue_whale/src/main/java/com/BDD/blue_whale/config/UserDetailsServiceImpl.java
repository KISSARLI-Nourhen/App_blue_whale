package com.BDD.blue_whale.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BDD.blue_whale.entities.User;
import com.BDD.blue_whale.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	  UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 User user = userRepository.findByEmail(email)
			        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));
		return UserDetailsImpl.build(user);
	}

}
