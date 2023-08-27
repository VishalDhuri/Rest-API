package com.example.demo.DTO;

import com.example.demo.validators.ValidateAbout;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Userdto {
	
	
	private String id;
	@NotBlank(message = "Username cannot be blank")
	private String name;
	@ValidateAbout
	private String about;
	private String gender;
	@Email(message = "Please Enter Vaild Email")
	private String email;
	@Size(min = 6,max = 20,message = "Password Must be More than 6 characters or Lower than 20")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&!])[A-Za-z\\d@#$%^&*!]{6,16}$")
	private String password;
	private String image;
	
}
