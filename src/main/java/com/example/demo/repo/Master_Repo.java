package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Master_Entity;


public interface Master_Repo extends JpaRepository<Master_Entity,Integer>{

	Optional<Master_Entity> findByUsername(String username);
}
