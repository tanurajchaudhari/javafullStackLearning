package com.aadiandjava.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
    private Integer id;
	@Column(unique=true)
    private String username;
    private String password;
    private String role;
    
}
