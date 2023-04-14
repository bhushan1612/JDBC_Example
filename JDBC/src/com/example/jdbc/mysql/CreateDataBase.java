package com.example.jdbc.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/hr";
		String username = "root";
		String password = "mysql@12345";
		
		String query= "CREATE DATABASE College";
		
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection con= DriverManager.getConnection(url,username,password);
		Statement stmt= con.createStatement();
		stmt.execute(query);
		
		System.out.println("Database Created....!");
		
		con.close();

	}

}
