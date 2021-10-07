package com.BDD.blue_whale.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BDD.blue_whale.entities.Department;
import com.BDD.blue_whale.entities.User;
import com.BDD.blue_whale.service.DepartmentService;
import com.BDD.blue_whale.service.UsersService;


@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private UsersService userService;
	
	
	
	
	
	/**********************************************************************************
	 * * User
	 **********************************************************************************/
	
	@GetMapping("/listUsers")
	public ResponseEntity<List<User>> users(){
		List<User> users = userService.listUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/listUsers/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") Long user_id){
		Optional<User> user =userService.getUserById(user_id);
		return new ResponseEntity<Optional<User>>(user,HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		userService.updateUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") long user_id){
		userService.deleteUser(user_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
