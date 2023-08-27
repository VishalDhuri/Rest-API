package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Address;
@RepositoryRestResource(path = "Address")
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
