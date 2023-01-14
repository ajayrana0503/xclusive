package com.xclusive.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.xclusive.entity.Users;

public interface UsersService extends UserDetailsService{
	public void saveUser(Users users);
	public Users getUserByEmail(String email);
}
