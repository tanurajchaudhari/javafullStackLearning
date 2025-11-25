package com.tanuraj;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		
//		Tanu tanu=(x,y)->System.out.println(x+y);
//		tanu.add(10, 20);
//		Tanu <Integer>tanu=(x,y)->System.out.println(x+y);
//		tanu.add(23, 23);
		
//		Tanu<String>tanu=(x,y)->System.out.println(x+y);
//		tanu.add("Tanuraj", "Chaudhari");
		
//		Tanu<Double>tanu=(x,y)->System.out.println(x+y);
//		tanu.add(2332.233, 3845.3487);
		
//		Tanu<int[]>tanu=(x,y)->System.out.println(Arrays.toString(x)+" "+Arrays.toString(y));
//		tanu.add(new int [] {11,22,33,44}, new int[] {99,88,77,66});
		
//		Tanu <Integer,String>tanu=(x,y)->System.out.println(x+""+y);
//		tanu.add(100, "Tanuraj");
		
//		Tanu <int [],String[]>tanu=(x,y)->System.out.println(Arrays.toString(x)+""+Arrays.toString(y));
//		tanu.add(new int[] {1,2,3,4,5,6,7}, new String[] {"Tanuraj","Gaurav"});
//		
//		Tanu<int [],String[],Integer>tanu=(x,y)->{
//			int sum =0;
//			for(int a:x) {
//				
//				sum+=a;
//			}
//			return sum;
//		};
//		tanu.add(new int[] {1,2,3,4}, new String[]{"Tanu","Sonu"});
	     
//		Tanu<Integer>tanu=(x,y)->x+y;
//		System.out.println(tanu.add(11, 22));
    
//		Tanu<String>tanu=(x,y)->y;
//		System.out.println(tanu.add("lagdive", "sir"));
    
//		Tanu <Integer,String,Integer> tanu=(x,y)->{
//			//return y.length();
//			return x;
//		};
//		System.out.println(tanu.add(8, "Ran"));
	  
//		Tanu <Integer,String> tanu=(x,y)->{
//			//return y.length();
//			return x;
//		};
//		System.out.println(tanu.add(8, "Ran"));
		
//		Tanu <int[],Integer>tanu=(x)->{
//			int sum=0;
//			for(int i:x) {
//				sum=sum+i;
//			}
//			return sum;
//		};
//		int sum=tanu.add(new int[] {12,23,12,23});
//	    System.out.println(sum);
        
		Tanu <String[],String>tanu=(x)->{
			
			for(String i:x) {
				if(i.startsWith("S")) {
					return i;
				}
			}
			return "String not found ";
		};
		String sum=tanu.add(new String[] {"Ram","ham","Good","Bad"});
	    System.out.println(sum);
	}
}
