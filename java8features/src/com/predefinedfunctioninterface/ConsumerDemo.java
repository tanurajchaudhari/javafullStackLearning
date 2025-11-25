package com.predefinedfunctioninterface;
import java.util.function.Consumer;
import java.util.ArrayList;
public class ConsumerDemo {
	public static void main(String[] args) {
//		Consumer<Integer> cm=(i)-> System.out.println(i);
//		cm.accept(10000);
		
//		Consumer<String> cm=(i)-> System.out.println("Hello  "+i.toUpperCase());
//		
//		cm.accept("Ramraje");
//		cm.accept("raje");

//        Consumer<int []> cm=(i)-> {
//        	
//        	
//        	for(int x: i) {
//        		
//        		System.out.println(x);
//        	}
//        };
//		
//		cm.accept(new int[] {1,2,3,4,5});
		
		Consumer<ArrayList<Integer>> cm=(i)->{
//			for(int x:i) {
//				System.out.println(x);
//			}
			//Java8 for loop
//			i.forEach((x)->System.out.println(x));
		};
		ArrayList<Integer>al=new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		cm .accept(al);
	}

}
