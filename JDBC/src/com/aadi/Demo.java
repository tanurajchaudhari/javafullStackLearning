package com.aadi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Demo {
//	static void insertDataUsingMethodParameter(int id,String name,double marks) throws ClassNotFoundException, SQLException{
//		Class.forName("com.mysql.cj.jdbc.Driver");//2nd step done
//		
//                                                       //URL                    //UserName     //password
//       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javawithtanuraj","root","Tanuraj@892002");//3rd step
//       Statement st=   conn.createStatement();
//      //st.execute("create database javawithtanuraj");
//      //st.execute("create table student(id int, name varchar(30),marks double)");
//      //st.execute("insert into student values(1,'Ram',67.78)");
//      //st.execute("insert into student values(2,'shyam',57.79),(3,'chetan',86.49)");
//      st.execute("insert into student values('"+id+"','"+name+"','"+marks+"')");
//      System.out.println("Database is created");
//	}

	static void insertDataUsingMethodParameter2(Student student) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");//2nd step done
		
                                                       //URL                    //UserName     //password
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javawithtanuraj","root","Tanuraj@892002");//3rd step
       Statement st=   conn.createStatement();
      //st.execute("create database javawithtanuraj");
      //st.execute("create table student(id int, name varchar(30),marks double)");
      //st.execute("insert into student values(1,'Ram',67.78)");
      //st.execute("insert into student values(2,'shyam',57.79),(3,'chetan',86.49)");
      st.execute("insert into student values('"+student.getId()+"','"+student.getName()+"','"+student.getMarks()+"')");
      System.out.println("Database is created");
	}
	
	static void updateData(Student student) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");//2nd step done
		
                                                   //URL                    //UserName     //password
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javawithtanuraj","root","Tanuraj@892002");//3rd step
       Statement st=   conn.createStatement();
		st.execute("update student set name ='"+student.getName()+"',marks='"+student.getMarks()+"' where id='"+student.getId()+"'");
		System.out.println("Data updated ");
	}
	static void deleteData(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");//2nd step done
		
                                                   //URL                    //UserName     //password
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javawithtanuraj","root","Tanuraj@892002");//3rd step
       Statement st=   conn.createStatement();
       st.execute("delete from student where id='"+id+"'");
       System.out.println("Data deleted ");
	}
	
	static void deleteAll() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");//2nd step done
		
                                                   //URL                    //UserName     //password
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javawithtanuraj","root","Tanuraj@892002");//3rd step
       Statement st=   conn.createStatement();
       st.execute("truncate table student");
       System.out.println("all data deleted ");
	}
	
	static void getAllRecords() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");//2nd step done
		
                                                   //URL                    //UserName     //password
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/javawithtanuraj","root","Tanuraj@892002");//3rd step
       Statement st=   conn.createStatement();
       ResultSet rs=st.executeQuery("select * from student");
       while(rs.next()) {
    	       int id= rs.getInt("id");
    	        String name=rs.getString("name");
    	        double marks=rs.getDouble("marks");
    	        System.out.println("id     :"+id);
    	        System.out.println("name   :"+name);
    	        System.out.println("marks  :"+marks);
    	        System.out.println("===========================");
    	   
       }
       System.out.println("all data get ");
	}
	public static void main(String[]args) throws ClassNotFoundException, SQLException {
//	    Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the id :-");
//	    int id=sc.nextInt();
//	    System.out.println("Enter the name of student :- ");
//	    String name=sc.next();
//	    System.out.println("Enter the marks of student");
//	    double marks=sc.nextDouble();
//	    insertDataUsingMethodParameter(id,name,marks);
		
//		Student student =new Student();
//		student.setId(3);
//		student.setName("adinath");
//		student.setMarks(88.95);
//		insertDataUsingMethodParameter2(student);
		
//		Student student =new Student();
//		student.setId(1);
//		student.setName("RamAndLakshman");
//		student.setMarks(43.43);
//		updateData(student);
		
		//deleteData(3);
		//deleteAll();	
		
		getAllRecords();
		
	}
}
 