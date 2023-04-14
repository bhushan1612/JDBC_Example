package com.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnection {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "HR";
		String password = "oraclehr";

		String query = "SELECT * FROM EMPLOYEES";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Reflection API
		Connection con = DriverManager.getConnection(url, userName, password);// Resource 1
		// connection object with connection parameter
		Statement s1 = con.createStatement();
		ResultSet rs = s1.executeQuery(query);// statement that execute on data base and store result in ResultSet
												// object

		while (rs.next()) {
			int employeeId = rs.getInt(1);
			String employeeName = rs.getString(2);
			String employeeLName = rs.getString(3);

			System.out.println("Employee Id :- " + employeeId);
			System.out.println("Employee Name:- " + employeeName);
			System.out.println("Employee Last Name:- " + employeeLName);
			System.out.println("*******************************************\n");

		}
		con.close();
		s1.close();
	}

}
