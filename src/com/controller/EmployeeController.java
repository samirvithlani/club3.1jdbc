package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.utils.DBConnection;

///stmt --> PreparesSattenent --> pre compile query
//1 --> 1 ms --> 1ms --2ms
//schema based database
//emp -- id name email age
//insert into emp(name,email,age)values(?,?,?)
//create table employees(id int primary key auto_increment,name varchar(30),email varchar(30),salary int);
public class EmployeeController {

	public void updateEmployee() {

		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			String updateSQL = "update employees set name=?,email=?,salary=? where id=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, "RAM");
				pstmt.setString(2, "ram@yahoo.com");
				pstmt.setInt(3, 30000);
				pstmt.setInt(4, 2);

				int res = pstmt.executeUpdate();
				if (res > 0) {
					System.out.println("record updated..");
				} else {
					System.out.println("record not updated...");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void addEmployees() {

		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getDbConnection();
		PreparedStatement pstmt = null;
		String insertSQL = "insert into employees(name,email,salary)values(?,?,?)";
		while (true) {
			if (conn != null) {

				// ? -> place holder..
				

				try {
					pstmt = conn.prepareStatement(insertSQL);
					System.out.println("enter employee name");
					String empName = sc.next();

					System.out.println("enter employee email");
					String empEmail = sc.next();

					System.out.println("enter emp salary");
					int salary = sc.nextInt();

					pstmt.setString(1, empName);
					pstmt.setString(2, empEmail);
					pstmt.setInt(3, salary);

					pstmt.addBatch();
					

					System.out.println("want to add more emp?? press 0 for exit");
					int choice = sc.nextInt();
					if (choice == 0) {
						break;
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			try {
				pstmt.executeBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void addEmployee() {

		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			// ? -> place holder..
			String insertSQL = "insert into employees(name,email,salary)values(?,?,?)";

			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				System.out.println("enter employee name");
				String empName = sc.next();

				System.out.println("enter employee email");
				String empEmail = sc.next();

				System.out.println("enter emp salary");
				int salary = sc.nextInt();

//				
//				pstmt.setString(1, "amit");
//				pstmt.setString(2, "amit@gmail.com");
//				pstmt.setInt(3, 23456);

				pstmt.setString(1, empName);
				pstmt.setString(2, empEmail);
				pstmt.setInt(3, salary);

				int res = pstmt.executeUpdate();

				if (res > 0) {
					System.out.println(res + " record inserted..");
				} else {
					System.out.println(res + " record inserted..");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// int res = pstmt.executeUpdate();
		}

	}

	
	
	
	public void getAllEmployees() {
		
		
		Connection conn = DBConnection.getDbConnection();
		if(conn!=null) {
			
			String SelectSQL = "select * from employees where id=?";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(SelectSQL);
				pstmt.setInt(1, 3);
				ResultSet rs = pstmt.executeQuery();
				//1-->more..
				//next -->true 
				//next->false..
				while(rs.next()) {
					System.out.print(" \t\t\t"+rs.getInt("id"));
					System.out.print(" \t\t\t"+rs.getString("name"));
					System.out.print(" \t\t\t"+rs.getString("email"));
					System.out.print(" \t\t\t"+rs.getInt("salary"));
					System.out.println();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		EmployeeController employeeController = new EmployeeController();
		// employeeController.addEmployee();
		// employeeController.updateEmployee();
		//employeeController.addEmployees();
		employeeController.getAllEmployees();

	}
}
