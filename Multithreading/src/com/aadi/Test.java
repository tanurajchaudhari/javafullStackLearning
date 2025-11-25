package com.aadi;

public class Test implements Runnable {

	@Override
	public void run() {
		if(Thread.currentThread().isDaemon()) {
			System.out.println("Thread is Daemon");
		}else {
			System.out.println("Thread is Not Daemon");
		}
		
		
	}
	public static void main(String[] args) {
		//Default thread- main =jvm
	 // we cant main thread as daemon thread
		// daemon thread is low priority thread 
		Test t= new Test();
		Thread t1=new Thread(t);
		t1.setName("Tanuraj");
		t1.setDaemon(true);//but JVM is define to make thread as daemon or not // uncertain behaviour 
		t1.start();
	}
}
