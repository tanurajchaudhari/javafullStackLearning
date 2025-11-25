package com.mr;

public class login {
	public login() {
		System.out.println("0 param constructor");
	}
	public login(int a) {
		System.out.println("1 param constructor");
	}
	void fun() {
		System.out.
		println("in on fun method in login class");
	}
//	void fun(int a) {
//		System.out.println("1 parameter method :-"+a);
//	}
	
	String fun(int a) {
		System.out.println("1 parameter method :-"+a);
		return "Ram";
	}
	static void m1() {
		System.out.println("In static method in login");
	}
	static void m2(String x) {
		System.out.println("In static method with string param in login");
	}
	
}
