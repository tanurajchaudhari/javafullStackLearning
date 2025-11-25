package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicatDemo {
	public static void main(String[] args) {

//		Predicate<Integer>p=(i)->i<50;
//		
//		boolean test=p.test(10);
//		boolean test1=p.test(100);
//		System.out.println(test);
//		System.out.println(test1);
		
//		String [] names= {"Ram","Aakash","Aadi","Rahul"};
//		Predicate<String>p=(name)->name.startsWith("A");
//		for(String name: names) {
//			if(p.test(name)) {
//				System.out.println(name);
//			}
//		}
		
		
//		Person p1=new Person("Aakash",34);
//		Person p2=new Person("Ram",14);
//		Person p3=new Person("Sachin",24);
//		Person p4=new Person("Rohit",21);
//		List<Person> persons  = Arrays.asList(p1,p2,p3,p4);
//		
//		//I want to print  the persons  whoes age  is less  than 18
//		Predicate<Person> p=(person)->person.age<18;
//		
//		for(Person person: persons) {
//			if(p.test(person)) {
//				System.out.println(person);
//			}
//		}
//		
		
		Employee  e1 = new Employee("Aadi","Pune","Java Developer");
		Employee  e2 = new Employee("tanuraj","mumbai","Python Developer");
		Employee  e3 = new Employee("Atharv","banglore","Devops");
		Employee  e4 = new Employee("sahil","gujrat","Springboot");
		Employee  e5 = new Employee("Aakash","Pune","aiml");
		
		List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5);
		
//		Predicate<Employee>p=(employee)->employee.city.equals("Pune");
//		
//		for(Employee employee: employees) {
//			if(p.test(employee)) {
//				System.out.println(employee);
//			}
//		}
		
		//Predicate joining 
//		Predicate<Employee>p1=(employee)->employee.city.equals("Pune");
//		Predicate<Employee>p2=(employee)->employee.name.startsWith("A");
//		Predicate<Employee>joined=p1.and(p2);
//		for(Employee employee: employees) {
//			if(joined.test(employee)) {
//				System.out.println(employee);
//			}
//		}
		
//		Predicate<Employee>p1=(employee)->employee.city.equals("Pune");
//		Predicate<Employee>p2=(employee)->employee.name.startsWith("A");
//		Predicate<Employee>joined=p1.or(p2);
//		for(Employee employee: employees) {
//			if(joined.test(employee)) {
//				System.out.println(employee);
//			}
//		}
	}

}
