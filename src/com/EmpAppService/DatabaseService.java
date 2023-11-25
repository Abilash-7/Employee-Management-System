package com.EmpAppService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.EmpApp.model.Employee;
import com.EmpApp.util.Database;
import com.EmpApp.util.Query;

public class DatabaseService {
	
	Database db = new Database();		//obj for DB connection
	
//	insert service
	public void insertEmp(Employee employee) throws SQLException {

		try (Connection con = db.getConnection();
				PreparedStatement ps =  con.prepareStatement(Query.insertEmployeeQuery());
				)	
		
		{
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setDouble(3, employee.getSalary());
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				System.out.println("recored created successfully !!!");
			}
			else {
				System.out.println("insert record failed !!!");
			}
				
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
	}//end of insert method
	
//	get Service
	public void getAllEmployee() throws SQLException{

		try (Connection con = db.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(Query.getEmployeeQuery());
				){
			
			while(rs.next()) {
				
				printEmployee(new Employee(rs.getInt("ID"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getDouble("SALARY")));
			}
		} 
		
		catch (Exception e) {
			System.out.println(e);
		}
		
	}//end of view all employee method

//	printing method 
	private void printEmployee(Employee employee) {

		System.out.println("\nEmployee ID : "+employee.getId());
		System.out.println("Employee Name : "+employee.getName());
		System.out.println("Employee Address : "+employee.getAddress());
		System.out.println("Employee Salary : "+employee.getSalary());
		System.out.println("\n======================================");
	}//end of print employee method
	
//	get service by id
	public boolean getEmployeeById(int id) throws SQLException {
		
		boolean isFound = false;
		
		try(Connection con = db.getConnection();
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(Query.getEmployeeByIdQuery(id));
				) {
			
			if (rs.next()) {
				isFound = true;
				printEmployee(new Employee(rs.getInt("ID"),rs.getString("NAME"),rs.getString("ADDRESS"),rs.getDouble("SALARY")));
			} 
			else {
				System.out.println("Record not found for id "+ id);
			}
			
		} 
		
		return isFound;
	}//end of getEmployee method
	
	
//	delete service
	public void deleteEmployee(int id) throws SQLException{
		
		try (Connection con = db.getConnection();
				Statement s = con.createStatement();
				) {

			int row = s.executeUpdate(Query.deleteEmployeeQuery(id));
			
			if(row > 0) {
				System.out.println("Record deleted successfully !!!");
			}
			else {
				System.out.println("Something went wrong.");
			}
		}
		
	}//end of deleteEmployee method
	
	
//	update service
	public void updateEmployee(Employee employee) throws SQLException {
		
		try(Connection con = db.getConnection();
				PreparedStatement ps = con.prepareStatement(Query.updateEmployeQuery(employee.getId()));
				) 
		{
		
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setDouble(3, employee.getSalary());
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				System.out.println("Record updated successfully !!!");
			}
			else {
				System.out.println("failed to update record.");
			}
			
		}
	}
	
}
