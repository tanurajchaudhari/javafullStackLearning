package com.list;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
public class ListDemo{
	
	//List => List can store different types ofdatat / Objects 
	//List can store an duplicate data 
	//List can store any no. of  null values
	// List follows insertion order 
	//List Follows indexing 
	//ArrayList is not good for insertion and deletion
	//ArrayList,LinkedList,Vector => stack
	
	public static void main(String []args) {
		//Arraylist is used for fetching the data from database 
		Student  s1=new Student(1,"ganesh",77.89);
		Student  s2=new Student(2,"sagar",87.76);
		Student  s3=new Student(3,"vaibhav",97.67);
		ArrayList<Student> st= new ArrayList<Student>();
		st.add(s1);
		st.add(s2);
		st.add(s3);
//		System.out.println(st);
//		for(Student i: st) {
//			System.out.println(i.getId());
//			System.out.println(i.getName());
//			System.out.println(i.getMarks());
//			System.out.println("=============================");
//		}
		//st.forEach(i-> System.out.println(i));

		
		
//		ArrayList al= new ArrayList();
//		al.add(10);// int => Integer
//		al.add('A');
//		al.add(true);//Boolean
//		al.add("Ram");
//		al.add(10);
//		al.add(null);
//		al.add(null);
//		System.out.println(al);
//		System.out.println(al.get(2));
		
		//<> => generic is used to  pass  Type of  the data
//		ArrayList<Object> al= new ArrayList<Object>();
//		al.add(10);// int => Integer
//		al.add('A');
//		al.add(true);//Boolean
//		al.add("Ram");
//		al.add(10);
//		al.add(null);
//		al.add(null);
//		al.add(new ListDemo());
//		System.out.println(al);

//		ArrayList<Integer> al =new ArrayList<Integer>();
//		//only integer values we can add  in this arraylist because it is generic integer value
//		al.add(10);
//		al.add(12);
//		al.add(32);
//		
//		System.out.println(al);
		
//		ArrayList<String> al =new ArrayList<String>();
//		//only String values we can add  in this arraylist because it is generic integer value
//		al.add("ram");
//		al.add("Sham");
//		al.add("Raju");
//		
//		System.out.println(al);
		
		//char,boolean,float,double,short,byte
		
		//List => List can store different types ofdatat / Objects 
		//ArrayList can store an duplicate data 
		//ArrayList can store any no. of  null values
		//ArrayList follows insertion order 
		//ArrayList Follows indexing 
		//ArrayList<Integer> al =new ArrayList<Integer>();
		//only integer values we can add  in this arraylist because it is generic integer value
//		al.add(10);
//		al.add(12);
//		al.add(32);
//		al.add(10);
//		al.add(null);
//		al.add(null);
		
		//I want to iterate the  my ArrayList
//		for(int i= 0;i<al.size();i++) {
//			System.out.println(al.get(i));
//		}
		
//		for(Integer i: al) {
//			System.out.println(i);
//		}
		
		//ListIterator is use in only list.
//        ListIterator<Integer> litr = al.listIterator();
//        while(litr.hasNext()) {
//        	System.out.println(litr.next());
//        }
		//it will use in list ,set ,queue as well
		//ALT+SHIFT+L  => return  type  extract
//		Iterator<Integer> itr = al.iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//		ArrayList<Integer> al2 =new ArrayList<Integer>();
//		al2.add(44);
//		al2.add(55);
		
//		System.out.println(al);
		
		//All methods are available  in LinkedList ,Vector,a nd stack
//		al.addAll(al2);
//		System.out.println(al);
//		System.out.println(al.get(2));
//		System.out.println(al.contains(12));
//		System.out.println(al.isEmpty());
		//al.clear();
		//System.out.println(al);
		//System.out.println(al.remove(3));
		//System.out.println(al.set(3, 300000));
//		System.out.println(al.indexOf(10));
//		System.out.println(al.lastIndexOf(10));
//		System.out.println(al.size());
//		System.out.println(al);
		
	}
	
}
