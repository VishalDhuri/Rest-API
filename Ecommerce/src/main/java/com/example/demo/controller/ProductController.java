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

import com.example.demo.DTO.Productdto;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	
	@PostMapping("/CreateProduct")
	public ResponseEntity<Productdto>Addproduct(@RequestBody Productdto productdto)
	{
		Productdto createproduct = productservice.createproduct(productdto);
		return new ResponseEntity<Productdto>(createproduct,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/DeleteProduct/{pid}")
	public void delete(@PathVariable ("pid") String pid)
	{
		productservice.deleteProduct(pid);
	}
	
	@PutMapping("/updateProduct/{pid}")
	public ResponseEntity<Productdto>updateProduct(@PathVariable ("pid") String pid, @RequestBody Productdto productdto)
	{
		Productdto prod = productservice.updateproduct(productdto, pid);
		return new ResponseEntity<Productdto>(prod, HttpStatus.OK);
	}
	
	@GetMapping("/AllProduct")
	public ResponseEntity<List<Productdto>>getAllProduct()
	{
		List<Productdto> list = productservice.getAllProduct();
		return new ResponseEntity<List<Productdto>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/PID/{pid}")
	public ResponseEntity<Productdto>getbypid(@PathVariable("pid")String pid)
	{
		Productdto bypid = productservice.getBypid(pid);
		return new ResponseEntity<Productdto>(bypid,HttpStatus.OK);
	}
	
	
	
	
}
