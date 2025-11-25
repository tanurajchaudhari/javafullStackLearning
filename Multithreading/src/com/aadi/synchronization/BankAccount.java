package com.aadi.synchronization;

public class BankAccount {
	int balance=0;
	public synchronized void withDraw(int amount) {
		System.out.println(Thread.currentThread().getName()+" is attempting to  withdraw:- "+amount);
		while(balance<amount) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		balance-=amount;
		System.out.println(Thread.currentThread().getName()+"WithDraw successfully new balance is: "+balance);
		
	}
	public synchronized void deposite(int amount) {
		System.out.println(Thread.currentThread().getName()+"Depositing : "+amount);
		balance+=amount;
		System.out.println(Thread.currentThread().getName()+"Deposited successfully : New balance is : "+balance);
		//notify();
		notifyAll();
	}

}
