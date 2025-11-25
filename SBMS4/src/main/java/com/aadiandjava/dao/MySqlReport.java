package com.aadiandjava.dao;

import org.springframework.stereotype.Repository;

@Repository("A")
//@Primary
public class MySqlReport implements ReportDao{
//	public MySqlReport() {
//        System.out.println("In MySqlReport dao");
//}

	@Override
	public void getReport() {
       System.out.println("getting report from MySql");		
	}

	

}
