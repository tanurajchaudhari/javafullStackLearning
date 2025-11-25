package com.aadi;

public class Demo implements Runnable{
	
	@Override
	public void run() {
		m1();m2();
		
		
	}
	public void m1() {
		for(int i=1;i<=10;i++) {
			System.out.println(i+" : "+Thread.currentThread().getName());
		}
	}
	public void m2() {
		for(int i=100;i>=90;i--) {
			System.out.println(i+" : "+Thread.currentThread().getName());
		}
	}
	public static void main(String []args) {
		
		Demo d=new Demo();
		Thread t=new Thread(d);
		t.start();
		
		Demo d1=new Demo();
		Thread t1=new Thread(d1);
		t1.start();
		
		Demo d2=new Demo();
		Thread t2=new Thread(d2);
		t2.start();
	}

}
