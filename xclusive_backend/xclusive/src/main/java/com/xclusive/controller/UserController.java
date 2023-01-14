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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xclusive.entity.Users;
import com.xclusive.jwt.JwtUtils;
import com.xclusive.security.service.UserDetailsImpl;
import com.xclusive.service.UsersService;

@RequestMapping("/user")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired
	private UsersService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/register")
	public void saveUser() {
		Users u= new Users();
//		u.setEmail(user.getEmail());
//		u.setName(user.getName());
//		u.setPassword(user.getPassword());
		u.setEmail("abc@gmil.com");
		u.setName("abc");
		u.setPassword("abc");
		this.userService.saveUser(u);
	}
	
	@PostMapping("/login")
	public Map<String,String> signin(@RequestBody Map m) {
		Authentication authentication= authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(m.get("email"),m.get("password")));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt= jwtUtils.generateJwtToken(authentication);
		UserDetailsImpl userDetails= (UserDetailsImpl) authentication.getPrincipal();
		Map<String, String> result= new HashMap<>();
		result.put("jwt", jwt);
		result.put("email", (String) m.get("email"));
		return result;
	}
	
}
