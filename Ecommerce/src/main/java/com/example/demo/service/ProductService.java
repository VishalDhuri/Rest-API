package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.Productdto;

public interface ProductService {
	
	Productdto createproduct (Productdto productdto);
	
	Productdto updateproduct(Productdto productdto,String pid);
	
	void deleteProduct(String pid);
	
	List<Productdto> getAllProduct();
	
	Productdto getbypvalue(String pvalue);

	Productdto getBypid(String pid);
}
