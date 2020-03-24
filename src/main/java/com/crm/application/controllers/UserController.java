package com.crm.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crm.application.models.ToDo;
import com.crm.application.models.User;
import com.crm.application.services.IUserService;

@RestController
@RequestMapping("/createUser")
public class UserController {
	@Autowired
	private IUserService userService;
	
	@PostMapping("/addUser")
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping("/findByName")
	public User findUser(@RequestParam String email) {
		return userService.findByEmail(email);
	}
	
	@GetMapping("/findByName2")
	public ResponseEntity<User> findUser2(@RequestParam String email) {
		return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.CREATED);
	}
	
}
