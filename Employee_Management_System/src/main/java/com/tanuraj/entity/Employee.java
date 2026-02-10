package com.tanuraj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data 
@Entity(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@NotBlank(message="Name  cant  be empty")
	@Size(min=5,max=20,message="Name ant be small than 5 characters and greater than 20 charaters")
	private String name;
	
	@NotBlank(message="Address cant be empty")
	private String address;
	
	@NotNull(message="Salary cant be null")
	@Positive(message="salary cant be negative")
	private Double salary;
	
	@NotBlank(message="department cant be empty")
	private String dep;
	
	@NotBlank(message="gender cant be empty")
	private String gender;
	
	@Email(message="Email is not valid")
	@NotBlank(message="Email cantbe  empty")
	private String email;
	
	@NotBlank(message="Password cand be null")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!._-]).{8,}$",
	message="Password must contain at least 8 characters, one uppercase, one lowercase, one digit, and one special character")
	private String password;
	
	

}
