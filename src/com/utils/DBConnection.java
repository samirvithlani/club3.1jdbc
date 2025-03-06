package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// port no: service host
	// userName:
	// password:
	// DriverClass

	// 6 steps of jdbc
	// loading driver class..
	// getting connection with database..

	// create statment object...
	// create queety
	// submit query
	// get result...

	private static String connectionURL = "jdbc:mysql://localhost:3306/club3_1";
	private static String userName = "root";
	private static String password = "root";
	private static String driverClass = "com.mysql.jdbc.Driver";

	public static Connection getDbConnection() {

		Connection conn =null;
		// driver load.. : driver class object...
		try {
			Class.forName(driverClass); // 1st step...

			conn = DriverManager.getConnection(connectionURL, userName, password);
			if (conn != null) {
				System.out.println("Connected to database..");
			} else {
				System.out.println("not connected to database..");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

//	public static void main(String[] args) {
//
//		getDbConnection();
//	}

}
