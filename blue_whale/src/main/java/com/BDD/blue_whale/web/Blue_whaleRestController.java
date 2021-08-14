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
import com.BDD.blue_whale.entities.Country_translation;
import com.BDD.blue_whale.entities.Faostat;
import com.BDD.blue_whale.entities.Import_export;
import com.BDD.blue_whale.entities.Product;
import com.BDD.blue_whale.entities.Product_translation;
import com.BDD.blue_whale.entities.Source;
import com.BDD.blue_whale.entities.World_language;
import com.BDD.blue_whale.repositories.FaostatRepository;
import com.BDD.blue_whale.repositories.Import_exportRepository;
import com.BDD.blue_whale.service.CountryService;
import com.BDD.blue_whale.service.Country_translationService;
import com.BDD.blue_whale.service.ProductService;
import com.BDD.blue_whale.service.Product_translationService;
import com.BDD.blue_whale.service.SourceService;
import com.BDD.blue_whale.service.World_languageService;



@RestController
@CrossOrigin("*")
public class Blue_whaleRestController {
	
	@Autowired
	private Import_exportRepository import_exportRepository;
	@Autowired
	private FaostatRepository faostatRepository;
	@Autowired
	private CountryService countryService;
	@Autowired 
	private ProductService productService;
	@Autowired
	private SourceService sourceService;
	@Autowired
	private Product_translationService product_translationService;
	@Autowired
	private World_languageService world_languagesService;
	@Autowired
	private Country_translationService country_translationService;
	

	/**********************************************************************************
	 * * product
	 **********************************************************************************/
	
	@GetMapping("/listproducts")
	public ResponseEntity<List<Product>> products(){
		List<Product> products = productService.listproduct();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/listproducts/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Long product_id){
		Optional<Product> product =productService.getProductById(product_id);
		return new ResponseEntity<Optional<Product>>(product,HttpStatus.OK);
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
	public ResponseEntity<Optional<Country>> getCountryById(@PathVariable("id") Long id){
		Optional<Country> country =countryService.getCountryById(id);
		return new ResponseEntity<Optional<Country>>(country,HttpStatus.OK);
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
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**********************************************************************************
	 * * source
	 **********************************************************************************/
	@GetMapping("/listesources")
	public ResponseEntity<List<Source>>  getsources(){
		List<Source> sources =sourceService.listSource();
		return new ResponseEntity<List<Source>>(sources, HttpStatus.OK);
	}
	
	@GetMapping("/listesources/{id}")
	public ResponseEntity<Optional<Source>> getSourceById(@PathVariable("id") Long source_id){
		Optional<Source> source= sourceService.getSourceById(source_id);
		return new ResponseEntity<Optional<Source>>(source, HttpStatus.OK);
	}
	
	@PostMapping("/addSource")
	public ResponseEntity<Source> addSource(@RequestBody Source source) {
		sourceService.addSource(source);
		return new ResponseEntity<Source>(HttpStatus.CREATED);
	}
	
	@PutMapping("/updateSource")
	public ResponseEntity<Source> updateSource(@RequestBody Source source){
		sourceService.updateSource(source);
		return new ResponseEntity<Source>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSource/{id}")
	public ResponseEntity<Source> deleteSource(@PathVariable("id") Long source_id){
		sourceService.deleteSource(source_id);
		return new ResponseEntity<Source>(HttpStatus.OK);
		
	}
	
	/**********************************************************************************
	 * * product translation
	 **********************************************************************************/
	@GetMapping("/listproductTranslations")
	public ResponseEntity<List<Product_translation>> getProductTranslation(){
		List<Product_translation> liste = product_translationService.listproduct_translation();
		return new ResponseEntity<List<Product_translation>>(liste, HttpStatus.OK);
	}
	
	@GetMapping("productTranslation/{id}")
	public ResponseEntity<Product_translation> getProductTranslationById(@PathVariable("id") Long translation_id){
		Product_translation productTrans = product_translationService.getProduct_translationById(translation_id);
		return new ResponseEntity<Product_translation>(productTrans, HttpStatus.OK);
	}
	
	@PostMapping("/addProductTranslation")
	public ResponseEntity<Product_translation> addProductTranslation(@RequestBody Product_translation p){
		product_translationService.addProduct_translation(p);
		return new ResponseEntity<Product_translation>(HttpStatus.CREATED);
	}
	
	/*@PostMapping("/createProductTranslation")
	public ResponseEntity<Product_translationDTO> createProductTranslation(@RequestBody Product_translationDTO p){
		product_translationService.create(p);
		return new ResponseEntity<Product_translationDTO>(HttpStatus.CREATED);
	}*/
	
	@PutMapping("/updateProductTranslation")
	public ResponseEntity<Product_translation> updateProductTranslation(@RequestBody Product_translation p){
		product_translationService.updateProduct_translation(p);
		return new ResponseEntity<Product_translation>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProductTranslation/{id}")
	public ResponseEntity<?> deleteProductTranslation(@PathVariable("id") Long translation_id){
		product_translationService.deleteProduct_translation(translation_id);
		return new ResponseEntity<>(HttpStatus.OK);
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
	
	
	/**********************************************************************************
	 * * word_language
	 **********************************************************************************/
	 
	@GetMapping("/listlanguages")
	public ResponseEntity<List<World_language>> getlanguages(){
		List<World_language> liste = world_languagesService.listWorld_language();
		return new ResponseEntity<List<World_language>>(liste, HttpStatus.OK);
	}
	
	
	/**********************************************************************************
	 * * country translation
	 **********************************************************************************/
	@GetMapping("/listecountry_translation")
	public ResponseEntity<List<Country_translation>> getCountryTranslation(){
		List<Country_translation> liste =country_translationService.listCountry_translation();
		return new ResponseEntity<List<Country_translation>>(liste, HttpStatus.OK);
	}
	
	@PostMapping("/addCountryTranslation")
	public ResponseEntity<Country_translation> addProductTranslation(@RequestBody Country_translation ct){
		country_translationService.addCountry_translation(ct);
		return new ResponseEntity<Country_translation>(HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCountryTranslation")
	public ResponseEntity<Country_translation> updateProductTranslation(@RequestBody Country_translation ct){
		country_translationService.updateCountry_translation(ct);
		return new ResponseEntity<Country_translation>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCountryTranslation/{id}")
	public ResponseEntity<?> deleteCountryTranslation(@PathVariable("id") Long translation_id){
		country_translationService.deleteCountry_translation(translation_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**********************************************************************************
	 * * import export
	 **********************************************************************************/
	
	
	
	
}
