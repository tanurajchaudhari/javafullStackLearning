package com.aadi;

public class Tanuraj extends Thread{
	@Override
	public void run() {
		
		super.run();
		m1();m2(); 
	}
	public void m1() {
		for(int i=0;i<=10;i++) {
			System.out.println(i+" : "+Thread.currentThread().getName());
		}
	}
	public void m2() {
		for(int i=0;i<=10;i++) {
			System.out.println(i+" : "+Thread.currentThread().getName());
		}
	}
	public  static void main(String[]args) {
		System.out.println(Thread.currentThread().getName());
		Tanuraj d=new Tanuraj();
		d.setName("Tanuraj");
		d.start();
		
		Tanuraj d1=new Tanuraj();
		d1.setName("bhshan");
		d1.start();
	}

}

