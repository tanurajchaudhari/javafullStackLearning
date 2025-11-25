package com.aadiandjava.service;

import java.util.ArrayList;
import java.util.List;

import com.aadiandjava.dao.UserDao;
import com.aadiandjava.entity.User;
import com.aadiandjava.exceptions.UserNotFoundException;

public class UserService {

	UserDao dao=new UserDao();
	public String saveUser(User user) {
		System.out.println("in service forward");
		return dao.saveUser(user);
		
	}
	public String insertAll(ArrayList<User>users) {
		return dao.insertAll(users);
	}
	public User getById(int id) {
		User byId=null;
		try {
			  byId = dao.getById(id);
		}catch(UserNotFoundException e) {
		System.out.println(e.getMessage());	
		
	   }
		return byId;
	}
	public List<User> getAllUsers(){
		return dao.getAllUsers();
	}
	public String UpdateUser(User user) {
		return dao.UpdateUser(user);
	}
}
