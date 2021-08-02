package com.BDD.blue_whale.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BDD.blue_whale.entities.Country;
import com.BDD.blue_whale.entities.Faostat;
import com.BDD.blue_whale.entities.Import_export;
import com.BDD.blue_whale.entities.Product;
import com.BDD.blue_whale.repositories.CountryRepository;
import com.BDD.blue_whale.repositories.FaostatRepository;
import com.BDD.blue_whale.repositories.Import_exportRepository;
import com.BDD.blue_whale.repositories.ProductRepository;
import com.BDD.blue_whale.service.CountryService;
import com.BDD.blue_whale.service.ProductService;



@RestController
@CrossOrigin("*")
public class Blue_whaleRestController {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private Import_exportRepository import_exportRepository;
	
	@Autowired
	private FaostatRepository faostatRepository;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired 
	private ProductService productService;
	

	/**********************************************************************************
	 * * product
	 **********************************************************************************/
	
	@GetMapping("/listproducts")
	public List<Product> products(){
		return productRepository.findAll();
	}
	
	@GetMapping("/listproducts/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long product_id){
		productService.getProductById(product_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return new ResponseEntity<Product>(HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		productService.updateProduct(product);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long product_id){
		productService.deleteProduct(product_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**********************************************************************************
	 * * country
	 **********************************************************************************/
	
	@GetMapping("/listcountries")
	public ResponseEntity<List<Country>> countries(){
		List<Country> countries = countryService.listCountry();
		return new ResponseEntity<>(countries, HttpStatus.OK);
	}
	
	@GetMapping("/listcountries/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable("id") Long id){
		Optional<Country> country =countryService.getCountryById(id);
		return new ResponseEntity<Country>(HttpStatus.OK);
	}
	
	@PostMapping("/addCountry")
	public ResponseEntity<?> addCountry(@RequestBody Country country) {
		countryService.addCountry(country);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCountry")
	public ResponseEntity<?> updateCountry(@RequestBody Country country) {
		countryService.updateCountry(country);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCountry/{id}")
	public ResponseEntity<?> deleteCountry(@PathVariable("id") long country_id){
		countryService.deleteCountry(country_id);
		return new ResponseEntity<Country>(HttpStatus.OK);
	}
	
	
	
	//import export
	@GetMapping("/listimport_exports")
	public List<Import_export> import_exports(){
		return import_exportRepository.findAll();
	}
	
	
	@GetMapping("/listfaostats")
	public List<Faostat> faostats(){
		return faostatRepository.findAll();
	}
	
	
	
	
	
}
