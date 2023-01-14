package com.xclusive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xclusive.entity.Users;
import com.xclusive.repository.UserRepository;

@Service
public class UserServiceImpl implements UsersService {

	@Autowired
	private UserRepository userRepository;
	
	
	public void saveUser(Users users) {
	this.userRepository.save(users);
	}
	
	public Users getUserByEmail(String email){
		return this.userRepository.getUserByEmail(email);
		
	}

	
}
