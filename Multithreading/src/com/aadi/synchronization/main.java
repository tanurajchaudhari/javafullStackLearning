package com.aadi.synchronization;

public class main {
	
	public static void main(String[]args) {
		BankAccount account =new BankAccount();
		/*Thread t1=new WithDrawThread(account,100);
        t1.setName("WithDrawThread");
        t1.start();
        Thread t2=new DepositeThread(account,500);
        t2.setName("Deposite-Thread");
        t2.start();
        */
		Thread t1=new WithDrawThread(account,100);
        t1.setName("WithDrawThread -1");
        t1.start();
        Thread t2=new WithDrawThread(account,100);
        t2.setName("WithDrawThread -2");
        t2.start();
        Thread t3=new WithDrawThread(account,100);
        t3.setName("WithDrawThread -3");
        t3.start();
        
        Thread t4=new DepositeThread(account,500);
        t4.setName("Deposite-Thread");
        t4.start();
		
	}


}
