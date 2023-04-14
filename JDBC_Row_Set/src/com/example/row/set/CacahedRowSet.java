package com.example.row.set;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CacahedRowSet {

	public static void main(String[] args) {
		Connection conn = null;
		CachedRowSet cahedRowSet = null;

		try {
			// Load JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "oraclehr");
			// Create JdbcRowSet object
			RowSetFactory factory = RowSetProvider.newFactory();
			cahedRowSet = factory.createCachedRowSet();
			cahedRowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			cahedRowSet.setUsername("HR");
			cahedRowSet.setPassword("oraclehr");
			cahedRowSet.setCommand("SELECT * FROM EMPLOYEES");
			cahedRowSet.execute();
			
			while (cahedRowSet.next()) {
	            System.out.println("ID: " + cahedRowSet.getInt("EMPLOYEE_ID"));
	            System.out.println("Name: " + cahedRowSet.getString("FIRST_NAME"));
	            System.out.println("Email: " + cahedRowSet.getString("EMAIL"));
	            System.out.println("Phone: " + cahedRowSet.getString("PHONE_NUMBER"));
	            System.out.println();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
