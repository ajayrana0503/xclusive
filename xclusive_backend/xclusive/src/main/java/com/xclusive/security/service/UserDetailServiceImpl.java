package com.xclusive.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xclusive.entity.Users;
import com.xclusive.service.UsersService;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	UsersService userService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user= userService.getUserByEmail(username);
		if(user==null) {
			new UsernameNotFoundException("user not found with email: "+username);
		}
		return UserDetailsImpl.build(user);
	}

	
}
