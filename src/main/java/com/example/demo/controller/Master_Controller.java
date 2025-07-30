package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Master_Entity;
import com.example.demo.repo.Master_Repo;

@RestController
public class Master_Controller {

	@Autowired
	private Master_Repo repo;
	@Autowired
	private PasswordEncoder encode;
	
	@PostMapping("/save")
	public String save(@RequestBody Master_Entity entity) {
		entity.setPassword(encode.encode(entity.getPassword()));
		Master_Entity master=repo.save(entity);
		return "Student Registered with ID:: "+master.getId();
	}
	
	
	@GetMapping("/profile")
	public String get() {
		return "You are Login successfully";
	}
	
	
	
	
	
	
	
	
	
	
	
}
