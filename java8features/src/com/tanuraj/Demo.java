package com.tanuraj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Demo{

//	@Override
//	public void add() {
//		
//		System.out.println(10+10);
//	}
	public static void main(String[] args) {
//		 Test t= ()-> {
//			
//			System.out.println(10+10);
//		};
//		t.add();
//		Test t=( x,  y)->{
//			System.out.println(x+y);
//		};
//		t.add(10,20);
//		t.add(100, 200);
//		Test t= (i,j)->{
//			return i+j;
//		};
//		System.out.println(t.add(11, 22));
		
//		Test t= (i)->{
//			int sum=0;
//			for(int x : i) {
//				sum=sum+x;
//			}
//			System.out.println("Sum is "+ sum);
//		};
//		int arr[]= {1,2,3,4,5};
//		t.doSum(arr);
//		Test t=()->{
//			int arr[]= {10,20,30,40,50};
//			return arr;
//		};
//		int [] array=t.getArray();
//		for(int x:array) {
//			System.out.println(x);
//		}
		
//		Test t=()->{
//			
//			return new int[] {11,22,33,44,55};
//		};
//		//int [] array=t.getArray();
//		for(int x:t.getArray() ){
//			System.out.println(x);
//		}
//		System.out.println(Arrays.toString(t.getArray()));
//		Test t=(u)->{
//			System.out.println(u.id);
//			System.out.println(u.name);
//			
//		};
//		User user = new User();
//		user.id=1;
//		user.name="Tanuraj";
//		t.takeuser(user);
		
//		Test t=()->{
//			User user =new User();
//			user.id=11;
//			user.name="Bhushan";
//			return user;
//		};
//		User user=t.getUser();
//		System.out.println(user.id);
//		System.out.println(user.name);
//		
//		Test t=()->{
//		    User [] user= new User[3];	
//		    User u1=new User();
//		    u1.id=111;
//		    u1.name="Abhay";
//		    User u2=new User();
//		    u2.id=222;
//		    u2.name="sudarshan";
//		    User u3=new User();
//		    u3.id=333;
//		    u3.name="gaurav";
//		    
//		    user[0]=u1;
//		    user[1]=u2;
//		    user[2]=u3;
//		    return user;
//
//		};
//		User []user=t.getUsers();
//		for(User u:user) {
//			System.out.println(u.id);
//			System.out.println(u.name);
//			System.out.println("================");
//		}
		
	/*	Test t=()->{
			ArrayList<User> al=new ArrayList<>();
			User u1=new User(111,"rahul");
		    
		    User u2=new User(222,"Karan");
		    
		    User u3=new User(333,"Sameer");
		    al.add(u1);
		    al.add(u2);
		    al.add(u3);
		    return al;
		};
		List<User> al=t.getUsers();
		for(User u:al) {
			System.out.println(u.id);
			System.out.println(u.name);
		}
		*/
//		Test t=()->{
//			ArrayList<Student> al=new ArrayList<>();
//			Student s1=new Student();
//			s1.id=99;s1.name="sagar";
//			al.add(s1);
//			Student s2=new Student();
//			s2.id=88;s2.name="prathmesh";
//			al.add(s2);
//			Student s3=new Student();
//			s3.id=77;s3.name="nishant";
//			al.add(s3);
//			
//			return al;
//		};
//		for(Student x: t.getStudent()) {
//			System.out.println(x.id);
//			System.out.println(x.name);
//		}
		
		Test t=(i)->{
			for(Employee x: i) {
				System.out.println(x.empId);
				System.out.println(x.empName);
				System.out.println(x.empSal);
				
				System.out.println("====================");	
			}	
		};
		ArrayList<Employee> al=new ArrayList<>();
		al.add(new Employee(123,"Shradha",2.5f));
		al.add(new Employee(543,"Mansi",4.3f));
		al.add(new Employee(278,"Sanyukta",5.3f));
		t.takeEmployes(al);
		
	}

}
