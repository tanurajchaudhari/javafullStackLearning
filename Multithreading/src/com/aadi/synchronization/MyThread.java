package com.aadi.synchronization;

public class MyThread extends Thread{
@Override
public void run() {
	System.out.println(Thread.currentThread().getName() +" is started ");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(Thread.currentThread().getName() +" is completed ");

}
public static void main(String[] args) {
	MyThread t1=new MyThread();
	t1.setName("T1");
	
	MyThread t2=new MyThread();
	t2.setName("T2");
	
	t1.start();
	try {
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	t2.start();
	
}
	
}
