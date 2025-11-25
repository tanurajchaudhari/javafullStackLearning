package com.aadiandjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[]args) {
		//IOC started
		
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
          PaymentService ps = context.getBean(PaymentService.class);
		  ps.doPayment(1111);
          System.out.println(ps.hashCode());
		
		
		
		
		
		
		
		
		
		
		
		
		
		//PaymentService payment= new PaymentService(); 
		 //Using field --> field/ variable level injection 
		//payment.cpayment=new CreditCardPayment();
		//payment.dpayment=new DebitCardPayment();
        
		//using constructor level injection
		//PaymentService payment1= new PaymentService(new DebitCardPayment()); 
        //using setter method 
//		PaymentService payment1= new PaymentService(); 
//        payment1.setPayment(new DebitCardPayment());
//		payment.payment=new CreditCardPayment();
//		payment.doPayment(1111);
//		payment.payment=new DebitCardPayment();
//
//		payment.doPayment(1111);
		
		
		
		
		
	}
     
}
