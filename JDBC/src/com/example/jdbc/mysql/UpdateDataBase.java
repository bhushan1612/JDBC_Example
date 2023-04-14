package com.example.jdbc.mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataBase {

	public static void main(String[] args)  throws IOException, ClassNotFoundException, SQLException {
		
		String url = "jdbc:mysql://localhost:3306/hr";
		String username = "root";
		String password = "mysql@12345";

		String insertquery="INSERT INTO student.studentrecords(StudentID,First_Name,Last_Name,Address,Mobile_No)"
				+ " VALUES(6,'Sammer','Patharwad','Pune',9632885214)";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		stmt.executeUpdate(insertquery);
		
		System.out.println("One Records Insert");
		
		//rs.close();
		con.close();		
	}

}
