package com.exam.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = "userRoles")
@ToString(exclude = "userRoles")

@Table(name="users")

@NoArgsConstructor
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private boolean enable= true;
	private String profile;
	

	//user many  roles
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private Set<UserRole>userRoles=new HashSet<>();


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority>authorities=new HashSet<>();
		this.userRoles.forEach(userRole->{
			authorities.add(new Authority(userRole.getRole().getRoleName()));
			System.err.println("collection of : "+userRole.getRole().getRoleName());
		});
		return authorities;
	}


	
	
	
}
