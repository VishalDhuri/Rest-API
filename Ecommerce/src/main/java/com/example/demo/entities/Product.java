package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Product {
	
	@Id
	private String pid;
	@Column(length = 20)
	private String pname;
	@Column(length = 1000)
	private String about;
	private String pvalue;
	
	@ManyToOne
	@JoinColumn(name = "Category_id")
	private Category category; 
}
