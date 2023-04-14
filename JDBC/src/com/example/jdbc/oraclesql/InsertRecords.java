package com.example.jdbc.oraclesql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecords {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "HR";
		String password = "oraclehr";
		
		String insert_query="INSERT INTO StudentDetails(Roll_No,First_Name,Last_Name,Address,Mobile_No)"
				+ " VALUES(106,'Vicky','Patharwad','Pune',9632885214)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,userName,password);
		Statement s1 = con.createStatement();
		s1.executeUpdate(insert_query);
		
		System.out.println("New Records Inserted...........");
		con.close();
	}
}
