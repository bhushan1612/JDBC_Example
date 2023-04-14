package com.example.jdbc.oraclesql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "HR";
		String password = "oraclehr";
		
		String query ="SELECT * FROM StudentDetails";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,userName,password);
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(query);
			
			System.out.println("Roll_No"+"\t\t\t" + "First_Name"+"\t"+"Last_Name"+"\t"+"Address"+"\t\t"+"Mobile_No"+"\t");

			while(rs.next()){
				int rollNo = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);
				String address = rs.getString(4);
				String mobileNo = rs.getString(5);
				System.out.print(rollNo+"\t\t\t");
				System.out.print(fName+"\t\t");
				System.out.print(lName+"\t\t");
				System.out.print(address+"\t\t");
				System.out.println(mobileNo+"\t\t");
			}
			rs.close();
			con.close();		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
