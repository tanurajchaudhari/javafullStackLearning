package com.StreamAPI;

public class Student {
String Name;
float marks;
@Override
public String toString() {
	return "Student [Name=" + Name + ", marks=" + marks + "]";
}
public Student(String name, float marks) {
	super();
	Name = name;
	this.marks = marks;
}
}
