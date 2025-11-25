package com.aadiandjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
//		 ReportService service = context.getBean(ReportService.class );
//		 service.generateReport();
		
//		Employee employee = context.getBean(Employee.class);
//		employee.showEmp();
		
		User u = context.getBean(User.class);
		System.out.println(u.hashCode());
		
		User u1 = context.getBean(User.class);
		System.out.println(u1.hashCode());
		
		User u2 = context.getBean(User.class);
		System.out.println(u2.hashCode());
	}
}
