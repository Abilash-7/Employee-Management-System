package com.EmpApp.util;

public class Query {

//	insert query
	public static String insertEmployeeQuery() {

		return "INSERT INTO EMPLOYEE_INFO (NAME,ADDRESS,SALARY) VALUES (?,?,?)";
		
	}
	
//	view Query
	public static String getEmployeeQuery() {

		return "SELECT * FROM EMPLOYEE_INFO";
		
	}
	
//	view query by id
	public static String getEmployeeByIdQuery(int id) {

		return "SELECT * FROM EMPLOYEE_INFO WHERE ID = " + id;
		
	}
	
//	delete query
	public static String deleteEmployeeQuery(int id) {

		return "DELETE FROM EMPLOYEE_INFO WHERE ID = " + id;
		
	}
	
//	update query
	public static String updateEmployeQuery(int id) {
		
		return "UPDATE EMPLOYEE_INFO SET NAME = ?, ADDRESS = ?, SALARY = ? WHERE ID = "+id;
		
	}

}
