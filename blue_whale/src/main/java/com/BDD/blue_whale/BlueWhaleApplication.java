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
import com.BDD.blue_whale.service.FileStorageService;
import com.BDD.blue_whale.service.UsersService;

import test.code_0_1.code;

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
	
	@Resource
	private FileStorageService FileStorageService;
	
	public static void main(String[] args) {
		SpringApplication.run(BlueWhaleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		FileStorageService.deleteAll();
		FileStorageService.init();
		
		//departmentRepository.save(new Department(null,"informatique", null));
		//usersService.saveDepartment(new Department(null,"informatique",users);
		//usersService.saveDepartment(new Department(null,"informatique"));
		//userRepository.save(new )
		//usersService.saveUser(new User(null,"nourhen","kissarli","123","nourhen@blue-whale.com",true,null,null));
		//
		//User users=userRepository.findByLastName("kissarli");
		//Role role=roleRepository.findByRole("admin");
		//System.out.println(users);
		//System.out.println(role);
		//usersService.addUsersToRole("kissarli", "admin");
		//Department dep = departmentRepository.findById((long) 1).get();
		//System.out.println(dep);
		//usersService.updateUser(new User(1L,"nourhen","kissarli","123","nourhen@blue-whale.com",true,dep,null));
		
	}

}
