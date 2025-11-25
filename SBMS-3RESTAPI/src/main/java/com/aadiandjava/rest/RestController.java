package com.aadiandjava.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController  //It is used to return the  response(JSON/Xml) from this classes 
//It is represent  we are creating rest apis in this class
public class RestController {

	//localhost:8080/welcome
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome we are Learning Rest API's  ";  // it goes to server in json format
	}
	@GetMapping("/names")
	public String[] getNames() {
		String[]names= {"Tanuraj","Sudarshan","Sunny","Bunty"};// it goes to server in json format
		return names;
	}
	@GetMapping("/user")
	public Map<Integer,String> getUser() {
		Map<Integer,String>user=new HashMap<Integer,String>();
		user.put(1,"Shashi sir");
		user.put(2,"ronak sir");
		user.put(3,"aadi sir");
		user.put(4,"angila mam");
		return user;

	}
	@GetMapping("/student")
	public Student getStudent() {
		Student student=new Student(1,"Bhushan","Pune");
		return student;
	}
	@GetMapping("/students")
	public List<Student> getStudents() {
		Student student1=new Student(1,"Bhushan","Pune");

		Student student2=new Student(2,"rushi","chakan");

		Student student3=new Student(3,"mi","Banglore");
		List<Student> students = Arrays.asList(student1,student2,student3);
		return students;

	}
	//localhost:8080/3
	@GetMapping("/byid/{id}")
	public Student getStudentbyId(@PathVariable int id) {
		System.err.println(id);
		Student student1=new Student(1,"Bhushan","Pune");
		Student student2=new Student(2,"rushi","chakan");
		Student student3=new Student(3,"mi","Banglore");
		List<Student> students = Arrays.asList(student1,student2,student3);

		for(Student student:students) {
			if(student.getId()==id) {
				return student;
			}
		}
           throw new StudentNotFoundException("Student not fouwith id :"+id);		
	}
	//localhost:8080/course
	@GetMapping("/student/{sid}/course/{cid}")
	public String getStudentAndCourse(@PathVariable int  sid,@PathVariable int cid) {
		if(sid==101&&cid==1) {
			return "Student Name : Tanuraj and  Student Course: SpringBoot ";
		}else if(sid==102&&cid==2) {
			return "Student Name : Sunny and  Student Course: dFarm ";

		}else {
			return "Student Not Found  ";

		}
	}
	@GetMapping(value= {"/abc","/abc/{city}"})
	public String getCity(@PathVariable(required=false)String city) {
		System.err.println("Method is called ");
		if(city==null) {
			return"City is dream  city";
		}else if(city.equals("Pune")) {
			return "City is Pune";
		}else if(city.equals("Mumbai")){
			return "City is Mumbai";
		}else {
			return "Unkonwn city";
		}
		
	}
	@GetMapping("/get")
	public String get(@RequestParam String msg,@RequestParam String msg2 ) {
		return "Hello: "+msg+","+msg2;
	}
	
	
	
}
