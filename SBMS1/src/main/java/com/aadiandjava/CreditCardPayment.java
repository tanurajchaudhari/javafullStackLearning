package com.aadiandjava;

public class CreditCardPayment implements IPayment{
//	
//	   public CreditCardPayment() {
//		System.out.println(" In creditcardpayment  constructor ");
//	}

	   @Override
      public void processPayment(double amount) {
    	  System.out.println("Payment processing via credit cart of rs :-"+amount);
      }

}
