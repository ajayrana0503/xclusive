package com.xclusive.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Demo {
	
	Logger logger = LoggerFactory.getLogger(getClass());
    
	@GetMapping("/helloworld")
	public Map<String, String> helloWorld() {
		logger.error("Fatal error");
		
		System.out.println("hello world");
		Map<String,String> mp=new HashMap<String,String>();
		mp.put("101", "Ajay");
		mp.put("102", "Ayush");
		return mp;
	}
	
}
