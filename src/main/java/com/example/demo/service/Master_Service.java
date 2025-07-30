package com.example.demo.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Master_Entity;
import com.example.demo.repo.Master_Repo;

@Service
public class Master_Service implements UserDetailsService{

	@Autowired
	private Master_Repo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Master_Entity> opt=repo.findByUsername(username);
		return new User(opt.get().getUsername(),opt.get().getPassword(),Collections.EMPTY_LIST);
	}

	
	
	
	
}
