package com.EmpApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static final  String Driver_PAth = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/employeedb";
	private static final String USERNAME = "root";
	private static final String PASSWORD= "root";
	
//	mysql jar file load
	public Database() {
		
		try {
		
			Class.forName(Driver_PAth);
				
		} 
		
		catch (Exception e) {
			
			throw new RuntimeException("Something went wrong." + e);
		}
		
	}
	
	
//	connection method with drivemanager
	public  Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
	}
	
}

