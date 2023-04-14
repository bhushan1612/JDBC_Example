package com.example.jdbc.mysql;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectQuery {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		
		
		String url = "jdbc:mysql://localhost:3306/hr";
		String username = "root";
		String password = "mysql@12345";

		String query= "SELECT * FROM student.studentmarkssheet";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		System.out.println("StudentID"+"\t\t" + "First_Name"+"\t"+"Last_Name"+"\t"+"Address"+"\t\t"+"Mobile_No"+"\t");

		while(rs.next()){
			int studentID = rs.getInt(1);
			String fName = rs.getString(2);
			String lName = rs.getString(3);
			String address = rs.getString(4);
			String mobileNo = rs.getString(5);
			System.out.print(studentID+"\t\t\t");
			System.out.print(fName+"\t\t");
			System.out.print(lName+"\t\t");
			System.out.print(address+"\t\t");
			System.out.println(mobileNo+"\t\t");
		}
		rs.close();
		con.close();		
	}

}
