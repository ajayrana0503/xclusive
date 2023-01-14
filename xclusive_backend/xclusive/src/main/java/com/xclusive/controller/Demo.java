package com.xclusive.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Demo {

	@GetMapping("/helloworld")
	//@PreAuthorize("isAuthenticated()")
	public Map<String, String> helloWorld() {
		System.out.println("hello world");
		Map<String,String> mp=new HashMap<String,String>();
		mp.put("101", "Ajay");
		mp.put("102", "Ayush");
		return mp;
	}
	
}
