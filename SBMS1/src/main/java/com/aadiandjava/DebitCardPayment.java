package com.aadiandjava;

public class DebitCardPayment implements IPayment {
	
//	public DebitCardPayment() {
//		System.out.println("In debitcardPayment constructor");
//	}

	@Override 
	public void processPayment(double amount) {
   	  System.out.println("Payment processing via debit cart of rs :-"+amount);
     }
}
