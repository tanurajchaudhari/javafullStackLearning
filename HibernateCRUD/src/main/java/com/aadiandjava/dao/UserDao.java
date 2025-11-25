package com.aadiandjava.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aadiandjava.entity.User;
import com.aadiandjava.exceptions.UserNotFoundException;
import com.aadiandjava.utility.HibernetConfig;

public class UserDao {
	public String saveUser(User user) {
		
		Session session = HibernetConfig.getHibernateSession();
		
		Transaction tr = session.beginTransaction();
		
		session.save(user);
		
		tr.commit();
		session.close();
		System.out.println("in dao");
		return "User Saved successfully";
	}
	public String insertAll(ArrayList<User>users) {
		Session session = HibernetConfig.getHibernateSession();
		Transaction tr = session.beginTransaction();
		
		for(User user:users) {
			session.save(user);
			
		}
		tr.commit();
		session.close();
		
		return "Users saved successfully";
	}
	public User getById(int id) {
		Session session =null;
		try {
		 session = HibernetConfig.getHibernateSession();
		User user = session.get(User.class, id);
		if(user!=null) {
			return user;
		}else {
			throw new UserNotFoundException("User Not found  wit ID: "+id);
		}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	public List<User> getAllUsers(){
		Session session =null;
		try {
		   session = HibernetConfig.getHibernateSession();
		   System.out.println("after session");
		   List<User> users = session.createQuery("from User").list();
		   System.out.println("after query");
		   return users;
		 
		}finally{
			if(session!=null) {
				session.close();
			}
		}
		
	}
	public String UpdateUser(User user) {
		Session session=null;
		int id1=user.getId();
		
		
		session = HibernetConfig.getHibernateSession();
		User user2 = session.get(User.class,id1);
		
		Transaction tr = session.beginTransaction();
		
		if(user2!=null) {
			if(user.getUsername() != null && !user.getUsername().isEmpty()){
				
				user2.setUsername(user.getUsername());
				System.out.println("Username is updated");
			}
			if(user.getEmail()!=null && !user.getEmail().isEmpty()) {
				user2.setEmail(user.getEmail());
				System.out.println("email is updated");

			}
			if(user.getPassword()!=null && !user.getPassword().isEmpty()) {
				user2.setPassword(user.getPassword());
				System.out.println("password is updated");

			}
			if(user.getAddress()!=null&& !user.getAddress().isEmpty()) {
				user2.setAddress(user.getAddress());
				System.out.println("address is updated");

				
			}
			session.update(user2);
			tr.commit();
			session.close();
		
		}else {
			tr.commit();
			session.close();
			return "User not found or user is null";
		}
	
		return "Data updated successfully";
		
		
		
	}
}
