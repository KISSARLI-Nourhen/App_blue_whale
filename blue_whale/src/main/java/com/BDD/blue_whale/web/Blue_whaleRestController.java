package com.BDD.blue_whale.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BDD.blue_whale.entities.Country;
import com.BDD.blue_whale.entities.Faostat;
import com.BDD.blue_whale.entities.Import_export;
import com.BDD.blue_whale.entities.Product;
import com.BDD.blue_whale.repositories.CountryRepository;
import com.BDD.blue_whale.repositories.FaostatRepository;
import com.BDD.blue_whale.repositories.Import_exportRepository;
import com.BDD.blue_whale.repositories.ProductRepository;



@RestController
public class Blue_whaleRestController {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private Import_exportRepository import_exportRepository;
	
	@Autowired
	private FaostatRepository faostatRepository;
	
	@GetMapping("/listproducts")
	public List<Product> products(){
		return productRepository.findAll();
	}
	
	
	@GetMapping("/listcountries")
	public List<Country> countries(){
		return countryRepository.findAll();
	}
	
	@GetMapping("/listimport_exports")
	public List<Import_export> import_exports(){
		return import_exportRepository.findAll();
	}
	
	@GetMapping("/listfaostats")
	public List<Faostat> faostats(){
		return faostatRepository.findAll();
	}
	
}
