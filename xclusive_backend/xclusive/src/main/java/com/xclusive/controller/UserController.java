package com.xclusive.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		u.setEmail("ajay@gmail.com");
		u.setName("ajay");
		u.setPassword("ajay");
		this.userService.saveUser(u);
	}
	
	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<Map> helloWorld(@PathVariable("email") String email ) {
		Map<String,Users> mp=new HashMap<String,Users>();
		Users user=userService.getUserByEmail(email);
		mp.put("email", user);
		return new ResponseEntity<Map>(mp, HttpStatus.BAD_REQUEST);
	}
	
}
