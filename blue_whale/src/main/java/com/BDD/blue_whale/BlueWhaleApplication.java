package com.BDD.blue_whale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.BDD.blue_whale.repositories.CountryRepository;
import com.BDD.blue_whale.repositories.DepartmentRepository;
import com.BDD.blue_whale.repositories.RoleRepository;
import com.BDD.blue_whale.repositories.UserRepository;
import com.BDD.blue_whale.service.CountryService;
import com.BDD.blue_whale.service.FileStorageService;
import com.BDD.blue_whale.service.UsersService;

@SpringBootApplication
public class BlueWhaleApplication implements CommandLineRunner{
	
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UsersService usersService;
	@Autowired
	private CountryService countryService;
	@Resource
	private FileStorageService FileStorageService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BlueWhaleApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		FileStorageService.deleteAll();
		FileStorageService.init();
		
		
		
		
		
		
		
	}

}
