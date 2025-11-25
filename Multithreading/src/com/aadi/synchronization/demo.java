package com.aadi.synchronization;

public class demo implements Runnable{

	@Override
	public void run() {
		printNum();
		
	}
	public synchronized  void printNum() {
		for(int i=1;i<=5;i++) {
			System.out.println(Thread.currentThread().getName()+" : "+i);
		}
	}
	public static void main(String[] args) {
		demo d=new demo();
		Thread t1=new Thread(d);
		t1.setName("T1");
		t1.start();
		Thread t2=new Thread(d);
		t2.setName("T2");
		t2.start();
	}
}
