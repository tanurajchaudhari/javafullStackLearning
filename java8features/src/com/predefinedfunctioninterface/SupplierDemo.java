package com.predefinedfunctioninterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.tanuraj.User;

public class SupplierDemo {
	public static void main(String[] args) {
//		Supplier<Integer>s=()-> 100;
//		System.out.println(s.get());
		
//		Supplier<String>s=()-> "Ganapati Bappa Morya";
//		System.out.println(s.get());
	    
//		Supplier<int []>s=()-> new int[] {11,22,33,44,55};
//		//System.out.println(Arrays.toString(s.get()));
//		int []names=s.get();
////		for(int x: names) {
////			System.out.println(x);
////		}
//		for(int i=0;i<names.length;i++) {
//			System.out.println(names[i]);
//		}
	
//		Supplier<String []>s=()-> new String[] {"ram","raju","ganesh","gaytonde"};
//		System.out.println(Arrays.toString(s.get()));
//		String []names=s.get();
//		for(String x: names) {
//			System.out.println(x);
//		}
//		for(int i=0;i<names.length;i++) {
//			System.out.println(names[i]);
//		}
		
		
//		Supplier<String>s=()->{
//			String otp="";
//			for(int i=0;i<6;i++) {
//				otp=otp+(int)(Math.random()*10);
//			}
//			return otp;
//		};
//		System.out.println(s.get());
		
		
		Supplier<List<User>> s=()->{
			List<User>users=Arrays.asList(new User(1,"ganesh"),new User(2,"Vivek"),new User(3,"vaibhav"));
		    return users;
		
		};
		List <User>users=s.get();
		users.forEach((x)->System.out.println(x));
		
		
		
		
		
		
	}

}
