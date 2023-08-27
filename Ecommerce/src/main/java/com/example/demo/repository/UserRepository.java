package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, String>{
	
	Optional<User> findByEmail(String email);	
	Optional<List<User>> findByAbout(String about);
	
	
	
	
	
}
