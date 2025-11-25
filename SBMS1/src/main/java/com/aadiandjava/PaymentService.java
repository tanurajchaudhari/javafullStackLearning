package com.aadiandjava;

public class PaymentService {
	public  PaymentService() {
		System.out.println("Payment service constructor called...");
	}
	public void fun() {
		System.out.println("Fun called ....");
	}
	//this is tight coupling 
	//CreditCardPayment cpayment= new CreditCardPayment();
	//DebitCardPayment dpayment=new DebitCardPayment();
	//CreditCardPayment cpayment;
	//DebitCardPayment dpayment;
	//suppose if 20 object are there then 20 refernce we have to ive .. so  for that  better to go with interface 
	IPayment payment;
	
	public PaymentService(IPayment payment) {
		System.out.println("in payment service constructor");
		this.payment=payment;
	}
	
	public void setPayment(IPayment payment) {
		this.payment=payment;
	}
	public void doPayment(double amount) {
		//cpayment.processPayment(amount);
		//dpayment.processPayment(amount);
		payment.processPayment(amount);
		System.out.println("Payment successful....");
		
	}

}
