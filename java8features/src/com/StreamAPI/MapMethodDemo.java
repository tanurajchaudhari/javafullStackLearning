package com.StreamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMethodDemo {
	public static void main(String[] args) {
//		String names[]= {"Ram","Shyam","Hari"};
		
		//List<String> users = Arrays.asList(names);
		//users.stream().map(user->user.toUpperCase()).forEach(i->System.out.println(i));
		//users.stream().map(user->user.toUpperCase()+" = "+user.length()).forEach(i->System.out.println(i));
//		users.stream().
//		filter(i->i.startsWith("S")).
//		map(user->user.toUpperCase()+" = "+user.length()).forEach(i->System.out.println(i));
	    
//		User u1=new User("Arnav",32);
//	    
//	    User u2=new User("Pranv",12);
//	    
//	    User u3=new User("suresh",21);
//	    
//	    User u4=new User("mangalbai",13);
//	    
//	    User u5=new User("priti",18);
//	    
//	    Stream<User> users = Stream.of(u1,u2,u3,u4,u5);
//	    users.filter(u->u.age>=18).filter(u->u.name.startsWith("A"))
//	    .map(u->u.name.toUpperCase()+" = "+u.age).forEach(i->System.out.println(i));
//	
	    //flayMap
		// it is used to combine 2 or more list.
//	    List<String> frontend = Arrays.asList("html","css","flutter","react");
//	    List<String> Backend = Arrays.asList("springboot","spring","database","server");
	    //nested list
//	    List<List<String>> courses = Arrays.asList(frontend,Backend);
	    //courses.forEach(i->System.out.println(i));
	    
//	    Stream<String> flatMap = courses.stream().flatMap(c->c.stream());
//		flatMap.forEach(i->System.out.println(i));
		
//		flatMap.map(course->course+" = "+course.length()).forEach(i->System.out.println(i));
		
		
		//------------Terminal methods --------------------------
		
//      List<String> frontend = Arrays.asList("html","flutter","flutter","react");
//      //skip method 
//      frontend.stream().skip(1).forEach(i->System.out.println(i));
//      //distinct method 
//      frontend.stream().distinct().forEach(i->System.out.println(i));
//      //count method
//      long count = frontend.stream().count();
//      System.out.println(count);
		
//		Person p1=new Person("rahul","Pune");
//		Person p2=new Person("chetan","Mumbai");
//		Person p3=new Person("ketan","nashik");
//		Person p4=new Person("kartik","banglore");
//		Person p5=new Person("sameer","baramati");
		
//		List<Person> persons = Arrays.asList(p1,p2,p3,p4,p5);
//		//anyMatch method
//		boolean status = persons.stream().anyMatch(person->person.city.equals("Pune"));
//		System.out.println("Any Person From pune :- "+status);
//		//allMatch method
//		boolean status1 = persons.stream().allMatch(person->person.city.equals("Pune"));
//		System.out.println("Any Person From pune :- "+status1);
//		
//		//noneMatch method
//		boolean status2 = persons.stream().noneMatch(person->person.city.equals("Dharashiv"));
//		System.out.println("Any Person From pune :- "+status2);
		
		
		
		
//		//collect method
//		List<Person> persons = Arrays.asList(p1,p2,p3,p4,p5);
//		//List<Person> person = persons.stream().collect(Collectors.toList());
////		List<Person> person = persons.stream().
////			filter(i->i.city.equals("Pune"))
////			.collect(Collectors.toList());
//		
//	
//		List<String> person = persons.stream().
//				filter(i->i.city.equals("Pune")).map(i->i.name+" = "+i.name.length())
//				.collect(Collectors.toList());
//			
//	
//		person.forEach(i->System.out.println(i));
		
		
		//Q.Create a employee class  and create  5 employee  objects and add it in to the list using stream api and print the name of employye whose department is it 
		
//		Employee emp1=new Employee("tanuraj","cs");
//		Employee emp2=new Employee("atharv","it");
//		Employee emp3=new Employee("abhay","it");
//		Employee emp4=new Employee("aditya","it");
//		Employee emp5=new Employee("aditya","cs");
//		
//		List<Employee> employees = Arrays.asList(emp1,emp2,emp3,emp4,emp5);
//		List<String> collect = employees.stream().
//			filter(f->f.empDept.equals("it")).
//			map(m->m.empName).
//			collect(Collectors.toList());
//		collect.forEach(i->System.out.println(i));
		
		//Q.Create a Student class  and create  5 Student  objects and add it in to the list using stream API and print the name of employye whose marks>90.
//		Student s1=new Student("Rahul",70);
//		Student s2=new Student("saurabh",99);
//		Student s3=new Student("ketan",43);
//		Student s4=new Student("sujit",960);
//		Student s5=new Student("tanu",100);
//		
//		List<Student> of = List.of(s1,s2,s3,s4,s5);
//		Stream<Student> students = of.stream();
//		List<String> collect = students.filter(i->i.marks>90).map(m->m.Name).collect(Collectors.toList());
//		collect.forEach(i->System.out.println(i));
//		
		//Q.Create a Book class  and create  5 Book  objects and add it in to the list using stream API and print the name of Books whose price <200.

		Book bk1= new Book("mrutyunjay",500);
		Book bk2= new Book("chava",199);
		Book bk3= new Book("shreeman yogi",150);
		Book bk4= new Book("yayati",300);
		Book bk5= new Book("fakira",179);
		
		List<Book> books = Arrays.asList(bk1,bk2,bk3,bk4,bk5);
		books.stream().filter(f->f.bkPrice<200).forEach(i->System.out.println(i.bkname));
		
		
	}

}
