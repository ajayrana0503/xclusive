package com.xclusive.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xclusive.entity.Users;
import com.xclusive.jwt.JwtUtils;
import com.xclusive.response.ResponseWrapper;
import com.xclusive.security.service.UserDetailsImpl;
import com.xclusive.service.UsersService;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController extends BaseController{

	@Autowired
	private UsersService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/register")
	public ResponseEntity<ResponseWrapper<Map<String,Object>>> saveUser(@RequestBody Users user) {
		Users newUser= new Users(user.getName(),user.getEmail(),encoder.encode(user.getPassword()));
	    try {
	    	userService.saveUser(newUser);
	    	Map<String, Object> result= new HashMap<>();
	    	result.put("user", newUser);
	    	return  wrapResponse(result,HttpStatus.OK,"User registered successfully");
	    }
	    catch(Exception e) {
	    	return wrapResponse(null,HttpStatus.IM_USED,"User already exists");
	    }
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseWrapper<Map<String,Object>>> signin(@RequestBody Users user) {
		try {
		Authentication authentication= authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt= jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl loggedInUser= (UserDetailsImpl) authentication.getPrincipal();
		Map<String, Object> result= new HashMap<>();
		result.put("user", loggedInUser);
		result.put("jwt", jwt);
		return wrapResponse(result,HttpStatus.OK,"logged in successfully");
		}
		catch(Exception e) {
			return wrapResponse(null,HttpStatus.FORBIDDEN,e.getMessage());
		}
	}
	
}
