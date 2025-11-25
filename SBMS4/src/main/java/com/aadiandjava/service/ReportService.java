 package com.aadiandjava.service;

import org.springframework.stereotype.Service;

import com.aadiandjava.dao.ReportDao;

@Service
public class ReportService {
//   public ReportService() {
//        System.out.println("in service constructor ");
//   }
   // field level injection
//   @Autowired
//   ReportDao Oracle; // null 
//   //ByNameinjection 
   
//   @Autowired
//   @Qualifier("B")// which dependent bean is to  qualifire
//   ReportDao dao; // null
   //bynameinjection 
   
   // constructor injection
//   ReportDao dao;
//   @Autowired
//    public ReportService(ReportDao dao) {
//	System.out.println("1 parameterized constructor ");
//	this.dao = dao;
//}

   //setter injection
   //  injection in annotation by using setter method 
   ReportDao dao;
//   @Autowired
//   public void setDao(ReportDao dao) {
//	   System.out.println("Setter is called ....");
//	   this.dao=dao;
//   }
	public void generateReport() {
    	dao.getReport();
    	System.out.println("Report is generated...");
    }
}
