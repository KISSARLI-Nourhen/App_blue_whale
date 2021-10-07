package com.BDD.blue_whale.web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BDD.blue_whale.entities.Country;
import com.BDD.blue_whale.entities.Country_translation;
import com.BDD.blue_whale.entities.Department;
import com.BDD.blue_whale.entities.Faostat;
import com.BDD.blue_whale.entities.Import_export;
import com.BDD.blue_whale.entities.Product;
import com.BDD.blue_whale.entities.Product_translation;
import com.BDD.blue_whale.entities.Role;
import com.BDD.blue_whale.entities.Source;
import com.BDD.blue_whale.entities.User;
import com.BDD.blue_whale.entities.World_language;
import com.BDD.blue_whale.repositories.FaostatRepository;
import com.BDD.blue_whale.repositories.Import_exportRepository;
import com.BDD.blue_whale.service.CountryService;
import com.BDD.blue_whale.service.Country_translationService;
import com.BDD.blue_whale.service.DepartmentService;
import com.BDD.blue_whale.service.FaostatService;
import com.BDD.blue_whale.service.ProductService;
import com.BDD.blue_whale.service.Product_translationService;
import com.BDD.blue_whale.service.RoleService;
import com.BDD.blue_whale.service.SourceService;
import com.BDD.blue_whale.service.UsersService;
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
	@Autowired
	private FaostatService faostatService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UsersService userService;
	@Autowired
	private RoleService roleService;
	
	

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
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		countryService.addCountry(country);
		return new ResponseEntity<Country>(HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCountry")
	public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
		countryService.updateCountry(country);
		return new ResponseEntity<Country>(HttpStatus.OK);
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
	 * * department
	 **********************************************************************************/
	
	@GetMapping("/listdepartments")
	public ResponseEntity<List<Department>> departments(){
		List<Department> departments = departmentService.listDepartment();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}
	
	@GetMapping("/listdepartments/{id}")
	public ResponseEntity<Optional<Department>> getDepartmentById(@PathVariable("id") Long id){
		Optional<Department> department =departmentService.getDepartmentById(id);
		return new ResponseEntity<Optional<Department>>(department,HttpStatus.OK);
	}
	
	@PostMapping("/addDepartment")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
		return new ResponseEntity<Department>(HttpStatus.CREATED);
	}
	
	@PutMapping("/updateDepartment")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		departmentService.updateDepartment(department);
		return new ResponseEntity<Department>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deletedepartment/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("id") long department_id){
		departmentService.deleteDepartment(department_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	/**********************************************************************************
	 * * Faostat
	 **********************************************************************************/
	
	private Sort.Direction getSortDirection(String direction){
		
		if(direction.equals("asc")){
			return Sort.Direction.ASC;
			
		} else if(direction.equals("desc")) {
			return Sort.Direction.DESC;
		}
		return Sort.Direction.ASC;
	}
	
	@GetMapping("/faostats")
	public ResponseEntity<Map<String, Object>> getAllFaostatsPage(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int size,
			@RequestParam(defaultValue = "id, desc") String[] sort){
		
		try {
			List<Order> orders = new ArrayList<Order>();
			
			if(sort[0].contains(",")) {
			// will sort more than 2 fields sortOrder="field, direction"
				for(String sortOrder : sort) {
					String[] _sort = sortOrder.split(",");
					orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
				} 
			} else {
		        // sort=[field, direction]
		        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
		      }
			
			List<Faostat> faostats = new ArrayList<Faostat>();
			Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

		      Page<Faostat> pageFaostats;
		      /*if (title == null) {
		        pageTuts = faostatRepository.findAll(pagingSort);
		      } else {
		        pageTuts = faostatRepository.findByTitleContaining(title, pagingSort);
		      }*/
		      pageFaostats = faostatRepository.findAll(pagingSort);
		    
		      faostats = pageFaostats.getContent();

		      Map<String, Object> response = new HashMap<>();
		      response.put("faostats", faostats);
		      response.put("currentPage", pageFaostats.getNumber());
		      response.put("totalItems", pageFaostats.getTotalElements());
		      response.put("totalPages", pageFaostats.getTotalPages());

		      return new ResponseEntity<>(response, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	/**********************************************************************************
	 * * import export
	 **********************************************************************************/
				
		@GetMapping("/import_exports")
		public ResponseEntity<Map<String, Object>> getAllimport_exportsPage(
				@RequestParam(defaultValue = "0") int page,
				@RequestParam(defaultValue = "20") int size,
				@RequestParam(defaultValue = "id, desc") String[] sort){
			
			try {
				List<Order> orders = new ArrayList<Order>();
				
				if(sort[0].contains(",")) {
					// will sort more than 2 fields sortOrder="field, direction"
						for(String sortOrder : sort) {
							String[] _sort = sortOrder.split(",");
							orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
						} 
					} else {
				        // sort=[field, direction]
				        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
				      }
				
				List<Import_export> Import_exports = new ArrayList<Import_export>();
				Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

			      Page<Import_export> pageImport_exports;
			     
			      pageImport_exports = import_exportRepository.findAll(pagingSort);
			    
			      Import_exports = pageImport_exports.getContent();

			      Map<String, Object> response = new HashMap<>();
			      response.put("Import_exports", Import_exports);
			      response.put("currentPage", pageImport_exports.getNumber());
			      response.put("totalItems", pageImport_exports.getTotalElements());
			      response.put("totalPages", pageImport_exports.getTotalPages());

			      return new ResponseEntity<>(response, HttpStatus.OK);
				
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}		
			
		}
		
		
		/**********************************************************************************
		 * * users
		 **********************************************************************************/
		
		@GetMapping("/listUsers")
		public ResponseEntity<List<User>> users(){
			List<User> users = userService.listUsers();
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
		
		@GetMapping("/listUsers/{id}")
		public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long id){
			Optional<User> user =userService.getUserById(id);
			return new ResponseEntity<Optional<User>>(user,HttpStatus.OK);
		}
		
		@PostMapping("/addUser")
		public ResponseEntity<User> addUser(@RequestBody User user) {
			userService.addUser(user);
			return new ResponseEntity<User>(HttpStatus.CREATED);
		}
		
		@PutMapping("/updateUser")
		public ResponseEntity<User> updateUser(@RequestBody User user) {
			userService.updateUser(user);
			return new ResponseEntity<User>(HttpStatus.OK);
		}
		
		@DeleteMapping("/deleteUser/{id}")
		public ResponseEntity<?> deleteUser(@PathVariable("id") long user_id){
			userService.deleteUser(user_id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		
		/**********************************************************************************
		 * * role
		 **********************************************************************************/
		
		@GetMapping("/listRoles")
		public ResponseEntity<List<Role>> roles(){
			List<Role> roles = roleService.listRoles();
			return new ResponseEntity<>(roles, HttpStatus.OK);
		}
		
		@PostMapping("/addRole")
		public ResponseEntity<Role> addRole(@RequestBody Role role) {
			roleService.addRole(role);
			return new ResponseEntity<Role>(HttpStatus.CREATED);
		}
		
		@PutMapping("/updateRole")
		public ResponseEntity<Role> updateRole(@RequestBody Role role) {
			roleService.updateRole(role);
			return new ResponseEntity<Role>(HttpStatus.OK);
		}
		
		@DeleteMapping("/deleteRole/{id}")
		public ResponseEntity<?> deleteRole(@PathVariable("id") long user_id){
			roleService.deleteRole(user_id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		

		
	
}
