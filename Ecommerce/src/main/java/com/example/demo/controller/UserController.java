package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.Userdto;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/createUser")
	public ResponseEntity<Userdto>addUser(@Valid @RequestBody Userdto userdto)
	{
		Userdto createUser = userservice.createUser(userdto);
		return new ResponseEntity<Userdto>(createUser,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public  void delete(@PathVariable("id") String id) 
	{
		 userservice.deleteUser(id);
	  }
	
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<Userdto>updateUser(@PathVariable("id") String id, @RequestBody Userdto userdto )
	{
		Userdto dto = userservice.updateUser(userdto, id);
		return new ResponseEntity<Userdto>(dto,HttpStatus.OK);
	}
	
	@GetMapping("/Allusers")
	public ResponseEntity<List<Userdto>> getAllUsers()
	{
		List<Userdto> list = userservice.getAlluser();
		return new ResponseEntity<List<Userdto>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/UserID/{id}")
	public ResponseEntity<Userdto>getId(@PathVariable("id") String id)
	{
		Userdto byid = userservice.getByid(id);
		return new ResponseEntity<Userdto>(byid,HttpStatus.OK);
	}
	
	@GetMapping("/Email/{email}")
	public ResponseEntity<Userdto>getbyEmail(@PathVariable("email") String email)
	{
		Userdto byEmail = userservice.getByEmail(email);
		return new ResponseEntity<Userdto>(byEmail, HttpStatus.OK);
	}
	
//	@GetMapping("/About/{about}")
//	public ResponseEntity<List<Userdto>>getByAbout(@PathVariable("about") String about) 
//	{
//		List<Userdto> byAbout = userservice.getByAbout(about);
//		
//		return new ResponseEntity<List<Userdto>>(byAbout,HttpStatus.OK);
//	}
//	
	
}