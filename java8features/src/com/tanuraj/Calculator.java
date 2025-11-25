package com.tanuraj;

public class Calculator {
	
	static void calculate(AO ao) {
		ao.calculate(100, 20);
		
	}
     public static void main(String[] args) {
    	 
    	 //Object Oriented Programming 
    	 // WE are passing  object to the another functions as argument.
//		Addition add= new Addition();
//		Subtraction sub=new Subtraction();
//		Multiplication mul =new Multiplication();
//		Division div= new Division();
		
//		calculate(add);
//		calculate(sub);
//		calculate(mul);
//		calculate(div);
		
//		calculate(new Addition());
//		calculate(new Subtraction());
//		calculate(new Multiplication());
//		calculate(new Division());
    	 
    	 // Functional programming 
    	 //WE are passing  functions as a argument. 
// 		calculate(  (int a, int b)-> {
// 			
// 			System.out.println("Addition is = "+(a+b));
// 			
// 		});
// 		calculate((int a, int b)-> {
// 			
// 			System.out.println("Subtraction is "+(a-b));
// 			
// 		});
// 		calculate(  (int a, int b)-> {
// 			System.out.println("Subtraction is "+(a-b));
// 			
// 		});
// 		calculate(  (int a, int b)-> {
// 			System.out.println("Division is "+(a/b));
// 			
// 		});
    	 
    	 
    		calculate(  (int a, int b)-> System.out.println("Addition is = "+(a+b)));
     			
     		
     		calculate((int a, int b)->System.out.println("Subtraction is "+(a-b)));
     			
     			
     			
     		
     		calculate(  (int a, int b)-> System.out.println("Subtraction is "+(a-b)));
     			
     			
     	
     		calculate(  (int a, int b)->System.out.println("Division is "+(a/b)));
     			
     			
     		
	}
}
