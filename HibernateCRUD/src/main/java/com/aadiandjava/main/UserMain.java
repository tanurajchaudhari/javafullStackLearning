package com.aadiandjava.main;

import com.aadiandjava.controller.UserController;
import com.aadiandjava.entity.User;

public class UserMain {
	public static void main(String[]args) {
	  UserController controller=new UserController();
	  
	  //1) save one users
	  
//	  User user =new User(1,"AadiAndJava","Aadi@gmail.com","aadi123","Pune");
//	  
//	  String msg = controller.saveUser(user);
//	  System.out.println(msg);
	  
	  
	  //2)Save multiple users at a time 
	  
//	  User user1=new User(2,"Tanuraj chaudhari","tanuraj169179@gmail.com","tanu2002","Pune");
//	  User user2=new User(3,"Bhushan chaudhari","bhush@gmail.com","bhusha2002","ahmedabadh");
//	  User user3=new User(4,"Durvesh chorghe","rushi@gmail.com","rushi2002","chakan");
//	  User user4=new User(5,"jaydeep chaudhari","jay@gmail.com","jay2002","vimannagar");
//	  ArrayList<User>users=new ArrayList<User>();
//	  users.add(user1);users.add(user2);users.add(user3);users.add(user4);
//	  String msg = controller.insertAll(users);
//	  System.out.println(msg);
	  
	  
	  //3)get user by Id
//	  User user = controller.getByID(8);
//	  System.out.println("backword main");
//	  System.out.println(user);
	  
	  
	  //4) get all users
//	 List<User>users= controller.getAllUsers();
//	 for(User user:users) {
//		 System.out.println(user);
//	 }
	  
	  //5) update the data of id 
	  User user =new User(5,"prajwal",null,"abba345","lonkar mala");
	  String msg = controller.UpdateUser(user);
	  System.out.println(msg);
	}
	

}
