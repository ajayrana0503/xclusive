package com.xclusive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xclusive.entity.Users;
import com.xclusive.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void saveUser(Users users) {
	this.userRepository.save(users);
	}
	
	public Users getUserByEmail(String email){
		return this.userRepository.getUserByEmail(email);
		
	}
}
