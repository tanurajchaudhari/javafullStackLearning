package com.aadiandjava.controller;

import java.util.ArrayList;
import java.util.List;

import com.aadiandjava.entity.User;
import com.aadiandjava.service.UserService;

public class UserController {
	UserService service=new UserService();
	public String saveUser(User user) {
		return service.saveUser(user);
	}
	public String insertAll(ArrayList<User>users) {
		return service.insertAll(users);
	}
	public User getByID(int id) {
		return service.getById(id);
	}
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	public String UpdateUser(User user) {
		return service.UpdateUser(user);
	}

}
