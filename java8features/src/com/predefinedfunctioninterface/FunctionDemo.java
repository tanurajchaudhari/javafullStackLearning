package com.predefinedfunctioninterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;

public class FunctionDemo {
	public static void main(String[] args) {
		
//		Function<Integer, Integer>f=(i)->i;
//		System.out.println(f.apply(10));
		
		
//		Function<Integer, String>f=(i)->{
//			//return Integer.toString(i);
//		    return String.valueOf(i);	
//		};
//		System.out.println(f.apply(10));
		
		
//		Function<int[],Integer>f=(i)->{
//			int sum=0;
//			for(int x:i) {
//				sum+=x;
//			}
//			return sum;
//			
//		};
//		System.out.println(f.apply(new int [] {11,22,11,12,13,23,32}));
		Function<int[],HashSet<Integer>>f=(i)->{
			HashSet <Integer>hs=new HashSet<>();
			for(int x:i) {
				hs.add(x);
			}
			return hs;
			
		};
		HashSet<Integer>hs=f.apply(new int [] {11,22,11,12,13,23,32});
		System.out.println(hs);

	
	}

}
