package com.aadi.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	private static  final String url="jdbc:mysql://localhost:3306/servlet";
	private static final String username="root";
	private static final String password="Tanuraj@892002";
	private static final String driverClassname="com.mysql.cj.jdbc.Driver";
	public  static Connection getDbConnection() {
		Connection connection=null;
		try {
		 Class.forName(driverClassname);
		    connection = DriverManager.getConnection(url, username, password);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
		
	}

}
