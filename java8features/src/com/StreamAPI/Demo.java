package com.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo {

	public static void main(String []args) {
//		Stream<Integer>numbers=Stream.of(1,2,3,4,5);
//		numbers.forEach(x->System.out.println(x));
//		Stream<String>names=Stream.of("Tanuraj","Sunny","Sanket","Prajwal");
//		names.forEach(x->System.out.println(x));
//		
//		String arr[]= {"Karan","Arjun","Nakul","Sahadev"};
//		List<String> asList = Arrays.asList(arr);
//		List<String> of = List.of(arr);
//		asList.forEach(i->System.out.println(i));
//		of.forEach(i->System.out.println(i));
		
		
		List<Integer>numbers=Arrays.asList(2,23,34,33,23,45,34,66,76,32);
		
//		for(int num: numbers) {
//			
//			if(num%2==0) {
//				System.out.println(num);
//			}
//		}
//		    Stream<Integer> stream = numbers.stream();
//		    Stream<Integer> filter = stream.filter(i->i%2==0);
//		    filter.forEach(i->System.out.println(i));
		    // above 3 lines can be done by in one line also  function chainning
		   // numbers.stream().filter(i->i%2==0).forEach(i->System.out.println(i));
		   // numbers.stream().filter(i->i%2==0).forEach(System.out::println);
//		    String [] names= {"Aarav","Karan","Abhishek","bunty"};
//            List<String> asList = Arrays.asList(names);	
//            asList.stream().filter(i->i.startsWith("A")).forEach(i->System.out.println(i));
	          
		    User u1=new User("Arnav",32);
		    
		    User u2=new User("Pranv",12);
		    
		    User u3=new User("suresh",21);
		    
		    User u4=new User("mangalbai",13);
		    
		    User u5=new User("prirti",18);
		    
		    Stream<User> users = Stream.of(u1,u2,u3,u4,u5);
//		    users.filter(i->i.age>=18).forEach(i->System.out.println(i));
		    users.filter(i->i.age>=18 && i.name.startsWith("A")).forEach(i->System.out.println(i));
	        users.filter(i->i.age>=18).filter(i->i.name.startsWith("A")).forEach(i->System.out.println(i));
	
	}
}
