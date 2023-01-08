package com.xclusive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xclusive.entity.Users;
import com.xclusive.service.UserService;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public void saveUser() {
		Users u= new Users();
		u.setEmail("ayush@gmail.com");
		u.setName("ayush");
		u.setPassword("ayush");
		this.userService.saveUser(u);
	}
	
}
