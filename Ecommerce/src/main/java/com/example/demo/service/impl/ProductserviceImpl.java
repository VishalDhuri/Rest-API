package com.example.demo.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.Productdto;
import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductserviceImpl implements ProductService {

		@Autowired
		ProductRepository repository;

		@Override
		public Productdto createproduct(Productdto productdto) {
			String pid = UUID.randomUUID().toString();
			productdto.setPid(pid);
			
			Product u = dtoToEntity(productdto);
			
			Product saveuser = repository.save(u);
			
			Productdto saveDto = entityToDto(saveuser);
			
			
		return saveDto;
	}

	@Override
	public Productdto updateproduct(Productdto productdto, String pid) {
		Product productupdate = repository.findById(pid).orElseThrow(()->new RuntimeException("Product Not Found"));
		productupdate.setPid(productdto.getPid());
		productupdate.setPname(productdto.getPname());
		productupdate.setAbout(productdto.getAbout());
		productupdate.setPvalue(productdto.getPvalue());
		
		Product save = repository.save(productupdate);
		
		Productdto savedto = entityToDto(save);
		return savedto;
	}

	@Override
	public List<Productdto> getAllProduct() {
		
		List<Product> productlist = repository.findAll();
		List<Productdto> collect = productlist.stream().map(Product->entityToDto(Product)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public Productdto getbypvalue(String pvalue) {
		
		return null;
	}

	@Override
	public Productdto getBypid(String pid)
	{
		Product u = repository.findById(pid).orElseThrow(()->new RuntimeException("User Not Delete"));
		Productdto dto = entityToDto(u);
		return dto;
		
	}
	
	
	public Product dtoToEntity (Productdto productdto)
	{
		Product build = Product.builder()
		.pid(productdto.getPid())
		.pname(productdto.getPname())
		.about(productdto.getAbout())
		.pvalue(productdto.getPvalue())
		.build();
		
		return build;
	}
	
	
	public Productdto entityToDto(Product product)
	{
		Productdto dto = Productdto.builder()
		.pid(product.getPid())
		.pname(product.getPname())
		.about(product.getAbout())
		.pvalue(product.getPvalue())
		.build();
		return dto;
		
	}
	
	
	@Override
	public void deleteProduct(String pid) {
		Product u= repository.findById(pid).orElseThrow(()->new RuntimeException("User Not Found"));
		repository.delete(u);
	}
	
	
}
