package com.bankapp.bankapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.bankapp.Services.UserService;
import com.bankapp.bankapp.models.RequestWrapper;
import com.bankapp.bankapp.models.User;

@RestController
public class userController {
	@Autowired
	private UserService userservice;
	
	@PostMapping("/createuser")
	public String createuser(@RequestBody User user) {
//		System.out.println("hi");
		
		Optional<User> u = userservice.findUserByEmail(user.getUserEmail());
		if(u.isEmpty()) {
//			System.out.println(user.toString());
			userservice.createUser(user);
//			System.out.println(user.toString());
			return "User Added";
		}else {
//			System.out.println("User is already in the system");
			return "User is already in the system";
		}
	}
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return userservice.getAllUsers();
	}
	
	@PostMapping("/usebyid/{id}")
	public User findUserByID(@PathVariable Integer id) {
		System.out.println("flutter called"+id);
		return userservice.findUserbyID(id);
	}
	@DeleteMapping("/deletebyid/{id}")
	public String deleteUserbyID(@PathVariable Integer id) {
		return userservice.deleteByID(id);
	}
	@CrossOrigin
	@GetMapping("/userall")
	public ResponseEntity list() {
		return ResponseEntity.status(HttpStatus.OK).body(new RequestWrapper(userservice.getAllUsers(),"good","done"));
	}
	
	

}
