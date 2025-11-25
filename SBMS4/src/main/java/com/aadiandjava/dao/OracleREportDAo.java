package com.aadiandjava.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("B")
@Primary
public class OracleREportDAo implements ReportDao{
//public OracleREportDAo() {
//System.out.println("In oracle report dao");
//}
	@Override
	public void getReport() {
       System.out.println("getting report from Oracle");		
	}

}
