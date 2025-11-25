package com.aadiandjava.configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aadiandjava.entity.Student;

public class Config {
	public static void main(String[]args) {
		
	   Configuration cfg=new Configuration();
	   cfg.configure();//read xml files
	   SessionFactory sf = cfg.buildSessionFactory();//to get the session 
	   Session session = sf.openSession();  //save,update,delete,get
//	   Transaction tr = session.beginTransaction();//it reqied for insert,update,delete records
//	   Student s1=new Student(1,"Tanuraj",75.34);
//	   session.save(s1);
//	   tr.commit();
//	   Transaction tr = session.beginTransaction();
//	   Student s2=new Student(2,"sunny",34.56);
//	   Student s3=new Student(3,"prajwal",86.70);
//	   Student s4=new Student(4,"sanket",90.89);
//	   ArrayList<Student> students =new ArrayList<>();
//	   students.add(s2);
//	   students.add(s3);
//	   students.add(s4);
//	   
//	   for(Student student:students) {
//		   session.save(student);
//	   }
//	   tr.commit();
//		session.close();
//		sf.close();
	   
	   //if we want to get the data by id transaction is not needed
//	   Student student=session.get(Student.class, 1);
//	   if(student!=null) {
//		   System.out.println(student);
//	   }else {
//		   System.out.println("student NOT Found");
//	   }
	   
	   //if u want to get all student
	   //Hql=> hibernate query  from Student;
	   //Sql => select * from Student;
	   
	   
//	   List<Student> students = session.createQuery("from Student").list();
//	   for(Student student:students) {
//		   System.out.println(student);
//	   }
	   
	   
	   
	   //if u  want the update the data
//	    Student student = session.get(Student.class, 2);
//	    Transaction tr = session.beginTransaction(); //for update transaction is required
//	    if(student!=null) {
//	    	student.setName("gandharv chaudhari");
//	    	student.setMarks(34.56);
//	    	session.update(student);
//	    	
//	     	tr.commit();
//	     	session.close();
//	    	
//	    }else {
//	    	System.out.println("Student NOT found");
//	    }
	   
	  // if u wnat to delete  records
	    Student student = session.get(Student.class, 2);
	    Transaction tr = session.beginTransaction();
	    
	    if(student!=null) {
	    	session.delete(student);
	    	
	     	tr.commit();
	     	session.close();
	    	
	    }else {
	    	System.out.println("Student NOT found");
	    }
	}
}
