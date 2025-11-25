package com.tanuraj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanuraj.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer>{

	Student findByEmailAndPassword(String email,String password);
}
