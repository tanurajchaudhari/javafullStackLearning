package com.predefinedfunctioninterface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BiconsumerDemo {
	public static void main(String[] args) {
//		Consumer<Integer>c1=(i)->System.out.println(i);
//		c1.accept(100);	
		
//		BiConsumer<Integer, Integer> bc=(i,j)-> System.out.println(i+j);
//		bc.accept(11,22);
	
//		Predicate<Integer>p=(i)->i>10;
//	    System.out.println(p.test(11));
		
//		BiPredicate<Integer,Integer>bp=(i,j)->i>j;
//		System.out.println(bp.test(11, 21));
		
		BiFunction<Integer, Integer, Integer>bf=(i,j)->{
			
			return i+j;
		};
		System.out.println(bf.apply(21,12));
		
	}
	
}
