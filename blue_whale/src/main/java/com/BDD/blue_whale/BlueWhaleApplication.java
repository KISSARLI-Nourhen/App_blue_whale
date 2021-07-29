package com.BDD.blue_whale;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.BDD.blue_whale.entities.Country;
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
		//FileStorageService.initOutPutData();
		
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
		
		
		//countryService.addCountry(new Country(null, "n2","nu2",1111, "null2", null, null, null, null));
		//Optional<Country> country1 = countryService.getCountryById(245);
		
		//countryService.updateCountry(new Country(245L,"N2","NU2",1111,"hoho",null,null,null,null));
		
	}

}
