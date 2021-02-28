package com.jwt.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.demo.model.User;
import com.jwt.demo.repository.UserRepository;

@Service
public class UserServices implements UserDetailsService{
	@Autowired
	UserRepository userRepository;

	public UserServices(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),new ArrayList<>());

	}
	
	
}
