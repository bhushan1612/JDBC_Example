package com.example.row.set;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetExample {

	 public static void main(String[] args) throws Exception {

	        // Create a Connection object to connect to the database
		    Class.forName("oracle.jdbc.driver.OracleDriver");
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        String user = "HR";
	        String password = "oraclehr";
	        Connection conn = DriverManager.getConnection(url, user, password);

	        // Create two CachedRowSet objects to retrieve data from the database
	        CachedRowSet employeesSet = RowSetProvider.newFactory().createCachedRowSet();
	        employeesSet.setCommand("SELECT * FROM EMPLOYEES");
	        employeesSet.execute(conn);

	        CachedRowSet departments = RowSetProvider.newFactory().createCachedRowSet();
	        departments.setCommand("SELECT * FROM DEPARTMENTS");
	        departments.execute(conn);

	        // Create a JoinRowSet object to join the two CachedRowSet objects
	        JoinRowSet joinSet = RowSetProvider.newFactory().createJoinRowSet();
	        joinSet.addRowSet(employeesSet, "EMPLOYEE_ID");
	        joinSet.addRowSet(departments, "MANAGER_ID");

	        // Print the data in the JoinRowSet
	        while (joinSet.next()) {
	            System.out.println("EMPLOYEE NAME: " + joinSet.getString("FIRST_NAME"));
	            System.out.println("MANAGER ID: " + joinSet.getInt("MANAGER_ID"));
	            System.out.println("DEPARTMENT NAME: " + joinSet.getString("DEPARTMENT_NAME"));
	            System.out.println("SALARY: " + joinSet.getString("SALARY"));
	            System.out.println();
	        }

	        // Close the CachedRowSet and Connection objects
	        employeesSet.close();
	        departments.close();
	        conn.close();
	    }
	}

