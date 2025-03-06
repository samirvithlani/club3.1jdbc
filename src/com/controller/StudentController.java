package com.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.utils.DBConnection;

public class StudentController {

	// create Statement : statement Obejct
	// prepare query
	// submit..
	// reslt..

	public void deleteStudent(int id) {
		
		
		Connection conn = DBConnection.getDbConnection();
		if(conn!=null) {
			
			try {
				Statement stmt = conn.createStatement();
				
				String deleteSQL = "delete from students where id ="+id+"";
				//submit..
				int res = stmt.executeUpdate(deleteSQL);

				if (res > 0) {
					System.out.println(res + " raws Dleted..");
				} else {
					System.out.println(res + " raws Deleted");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	
	
	public void addStudent() {

		// 2step...
		Connection conn = DBConnection.getDbConnection();
		if (conn != null) {

			try {
				Statement stmt = conn.createStatement(); // statment interface... "query" ->Database -->""
				// 4th step ---->quety

				String name = "ajay";
				//String insertSQL = "insert into students(name,age,marks)values('amit',23,40)";
				String insertSQL = "insert into students(name,age,marks)values('"+name+"',23,40)";

				// query submit
				int res = stmt.executeUpdate(insertSQL);// int DML DDL
				// boolean res1 = stmt.execute(insertSQL); true --> DDL -->FALSE
				// stmt.executeQuery(insertSQL) DDL -->

				if (res > 0) {
					System.out.println(res + " raws inserted..");
				} else {
					System.out.println(res + " raws inserted");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			// throw...
		}

	}

	public static void main(String[] args) {

		StudentController studentController = new StudentController();
		studentController.addStudent();
		//studentController.deleteStudent(1);

	}
}
