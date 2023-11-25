package com.EmpApp.main;

import java.util.Scanner;

import com.EmpApp.model.Employee;
import com.EmpAppService.DatabaseService;

public class Main {

	public static void main(String[] args) {
		
		DatabaseService dbService = new DatabaseService();	//Obj for DB connection with services
		
		try(Scanner sc = new Scanner(System.in)) {
			
			boolean isRunning = true;
			
			while(isRunning) {
				

				System.out.println("\nWelcome to Employee management application\n");
				System.out.println("1.Add Employee\n" + "2.View all Employee\n" + "3.View Employee by id\n" + "4.Update\n"
						+ "5.Delete\n" + "6.Exit\n");
				System.out.println("Enter Choice : ");


				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1:
					System.out.println("Enter name, address, salary");
					dbService.insertEmp(new Employee(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()) ));
					break;
					
				case 2:
					dbService.getAllEmployee();
					break;
					
				case 3:
					System.out.println("Enter id of an Employee : ");
					dbService.getEmployeeById(Integer.parseInt(sc.nextLine()));
					break;
					
				case 4:
					System.out.println("Enter id of an Employee : ");
					int updateId = Integer.parseInt(sc.nextLine());
					boolean isfound = dbService.getEmployeeById(updateId);
					
					if(isfound) 
					{
						System.out.println("Enter name, address, salary");
						Employee employee = new Employee(updateId,sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()) );
						dbService.updateEmployee(employee);
					}
					
					break;
					
				case 5:
					System.out.println("Enter id of an Employee : ");
					dbService.deleteEmployee(Integer.parseInt(sc.nextLine()));
					break;
					
				case 6:
					System.out.println("Thank you visit again !!!");
					isRunning = false;
					break;
					
				default:
					System.out.println("Enter Valid choice !!!");
					break;
				}

			}
			
		}//End of an main method
		
		catch (Exception e) 
		{
			throw new RuntimeException("Something went Wrong "+e);
		}
		
	}

}
