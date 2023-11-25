package com.EmpApp.model;

public class Employee {
	
	private int id;
	private String Name;
	private String Address;
	private double Salary;
	
//	constructors
	public Employee(int id, String name, String address, double salary) 
	{
		super();
		this.id = id;
		Name = name;
		Address = address;
		Salary = salary;
	}
	
	public Employee(String name, String address, double salary) {
		super();
		Name = name;
		Address = address;
		Salary = salary;
	}
	
	
//	Getter / setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	
	
}
