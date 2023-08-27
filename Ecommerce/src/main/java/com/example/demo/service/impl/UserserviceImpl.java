package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.Userdto;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Service
public class UserserviceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Override
	public Userdto createUser(Userdto userdto) {
		//Generate Random ID
		String id = UUID.randomUUID().toString();		
		userdto.setId(id);
		
		//conversion from dto to Entity
		User u = dtoToEntity(userdto);
		
		//saving user object
		User savedUser = repository.save(u);
		
		//entity toDtot
		Userdto savedDto=entityToDto(savedUser);
		
		return savedDto;
	}
	

	@Override

	public Userdto updateUser(Userdto userdto, String id) {
		User update = repository.findById(id).orElseThrow(()->new UserNotFoundException("Id Not Found"));
		update.setName(userdto.getName());
		update.setAbout(userdto.getAbout());
		update.setPassword(userdto.getPassword());
		update.setEmail(userdto.getEmail());
		update.setGender(userdto.getGender());
		update.setImage(userdto.getImage());
		
		User savedUser = repository.save(update);
		
		Userdto saveddto = entityToDto(savedUser);
		
		return saveddto;
	}

	@Override
	public void deleteUser(String id) {
		
		User u = repository.findById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
		repository.delete(u);
	}

	@Override
	public List<Userdto> getAlluser() {
		List<User> Userlist = repository.findAll();
		List<Userdto> dtolist = Userlist.stream().map(user->entityToDto(user)).collect(Collectors.toList());
		
		return dtolist;
	}

	@Override
	public Userdto getByid(String id) {
		User u=repository.findById(id).orElseThrow(()->new UserNotFoundException("User not found by this id"));
		Userdto dto = entityToDto(u);
		
		return dto;
	}

	@Override
	public Userdto getByEmail(String email) {
		User userEmail = repository.findByEmail(email).orElseThrow(()->new UserNotFoundException());
		Userdto email1 = entityToDto(userEmail);
		return email1;
	}
	
	

//	@Override
//	public List<Userdto> getByAbout(String about) {
//		Optional<List<User>> all = repository.findByAbout(about);
//		all.stream().map(user->entityToDto(user)).collect(Collectors.toList());
//
//		return null;
//	}

	
	
	
//	Dto to Entity
	
	public User dtoToEntity(Userdto userdto)
	{
		User build = User.builder()
		.id(userdto.getId())
		.name(userdto.getName())
		.about(userdto.getAbout())
		.password(userdto.getPassword())
		.email(userdto.getEmail())
		.gender(userdto.getGender())
		.image(userdto.getImage())
		.build();
		
		return build;
	}
	
	
//	Entity to DTO
	
	public Userdto entityToDto(User user)
	{
		
		Userdto dto = Userdto.builder()
		.id(user.getId())
		.name(user.getName())
		.password(user.getPassword())
		.image(user.getImage())
		.about(user.getAbout())
		.email(user.getEmail())
		.gender(user.getGender())
		.build();
		return dto;
	}


	@Override
	public List<Userdto> getByAbout(String about) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
