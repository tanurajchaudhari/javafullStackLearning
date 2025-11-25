package com.aadi.synchronization;

public class DepositeThread extends Thread{
	BankAccount account;
	int amount ;
	
	public DepositeThread(BankAccount account, int amount) {
		super();
		this.account = account;
		this.amount = amount;
	}
@Override
public void run() {

	account.deposite(amount);
}	

}
