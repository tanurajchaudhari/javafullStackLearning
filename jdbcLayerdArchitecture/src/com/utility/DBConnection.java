package com.utility;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	private static final String url ="jdbc:mysql://localhost:3306/jdbc";
	private static final String username="root";
	private static final String password="Tanuraj@892002";
	public static Connection jdbcConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
