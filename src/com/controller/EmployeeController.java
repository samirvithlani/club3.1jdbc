package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		if(conn!=null) {
			
			String updateSQL = "update employees set name=?,email=?,salary=? where id=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, "RAM");
				pstmt.setString(2, "ram@yahoo.com");
				pstmt.setInt(3, 30000);
				pstmt.setInt(4, 2);
				
				int res = pstmt.executeUpdate();
				if(res>0) {
					System.out.println("record updated..");
				}
				else {
					System.out.println("record not updated...");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
				
		
		
	}
	
	
	public void addEmployee() {
	
		Scanner sc = new Scanner(System.in);
		Connection conn = DBConnection.getDbConnection();
		if(conn!=null) {
			
			//? -> place holder..
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
				if(res>0) {
					System.out.println(res+" record inserted..");
				}
				else {
					System.out.println(res+" record inserted..");
				}
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
	}
	

	
	public static void main(String[] args) {
		
		
		EmployeeController employeeController = new EmployeeController();
		//employeeController.addEmployee();
		employeeController.updateEmployee();
		
		
	}
}
