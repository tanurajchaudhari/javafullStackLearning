package com.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(exclude = "user")
@ToString(exclude = "user")

@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long userRoleId;
	
	//USer 
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	@ManyToOne
	private Role role;
	
	
	
	
	
}
