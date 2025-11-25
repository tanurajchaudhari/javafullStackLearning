package com.aadi.synchronization;

public class WithDrawThread extends Thread{
	BankAccount account;
	int amount ;
	
	public WithDrawThread(BankAccount account, int amount) {
		super();
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		account.withDraw(amount);
	}

}
