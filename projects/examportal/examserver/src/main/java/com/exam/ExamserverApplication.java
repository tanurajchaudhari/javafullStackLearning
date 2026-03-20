package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.helper.UserFoundException;
import com.exam.service.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Autowired
	public  BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		System.out.println("Starting Code runner");
//		
//		try {
//		User user=new User(	); 
//		user.setFirstName("Tanuraj"); 
//		user.setLastName("Chaudhari"); 
//		user.setUsername("Tanuraj2002"); 
//		user.setPassword(bcryptPasswordEncoder.encode("Tanuraj@892002")); 
//		user.setEmail("tanuraj169179@gmail.com");
//		user.setProfile("default.png");
//		user.setPhone("8600169179"); 
//		Role role1=new Role(); 
//		role1.setRoleId(44); 
//		role1.setRoleName("Admin");
//		Set<UserRole>userRolesSet=new HashSet<>(); 
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1); 
//		userRole.setUser(user); 
//		userRolesSet.add(userRole); 
//		User user2=this.userService.createUser(user, userRolesSet); 
//		System.out.println(user2.getFirstName());
//	    User user1 = this.userService.getUser("Gaurav");
//	    System.err.println(user1);
//	}catch(UserFoundException e) {
//		e.printStackTrace();
//	}	 
		 		
	}

}
