package com.aadiandjava.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
// we annote @data instead of @Setter,@Getter,@ToString

@Entity
public class User {
    @Id
	private int id;
	private String username;
	private String email;
	private String password;
	private String address;
	
	
}
