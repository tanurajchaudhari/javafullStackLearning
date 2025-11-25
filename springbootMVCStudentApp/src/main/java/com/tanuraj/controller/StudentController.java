package com.tanuraj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tanuraj.entity.Student;
import com.tanuraj.repo.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping({"/registration","studentform"})
	public String studentRegistrationForm(Model model) {
		Student  s1=new Student();
		model.addAttribute("student",s1);
		return "student-registration";
	}
	
	@PostMapping("/register")
	public String registerRegister(Student student ,Model model) {
		studentRepository.save(student);
		System.err.println(student);
		model.addAttribute("msg","Student Save  Sccessfully...");
		return "student-registration";
	}
	@GetMapping("/students")
	public String getAllsudents(Model model) {
		List<Student> students = studentRepository.findAll();
		model.addAttribute("students",students);
		return "students";
	}
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id ) {
		studentRepository.deleteById(id);
		return"redirect:/students";
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable int id,Model model){
		Student student = studentRepository.findById(id).orElse(null);
		model.addAttribute("student",student);
		return "edit-student";
		
	}
	@PostMapping("/update")
	public String updateStudent(Student student) {
	        studentRepository.save(student);
	        return "redirect:/students";
	}
	 
	 @GetMapping("/home")
	 public String getHomePage() {
		
		 return "home-page";
	 }
	
	 @GetMapping("/login")
	 public String loginStudent() {
		 return "login-page";
	 } 
	 
	 @PostMapping("/loginStudent")
	 public String checkLoginStudent(String email,String password,Model model) {
		 Student student = studentRepository.findByEmailAndPassword(email,password);
		 if(student!=null) {
			 model.addAttribute("student",student);
			 return "login-success";
		 }else {
			 model.addAttribute("error","Incorect Email OR Password");
			 return "login-page";
		 }
	 }

}
