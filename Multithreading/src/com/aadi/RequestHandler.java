package com.aadi;

public class RequestHandler extends Thread{

	@Override
	public void run() {
		System.out.println("Request starting : "+Thread.currentThread().getName());
		  
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Request completing : "+Thread.currentThread().getName());

	}
	
	public static void main(String[]args) {
		System.out.println("Main thread started");
		for(int i=1;i<=5;i++) {
			RequestHandler handler=new RequestHandler();
			handler.start();
		}
		System.out.println("Main thread ended");

	}
}
