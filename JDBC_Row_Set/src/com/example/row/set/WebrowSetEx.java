package com.example.row.set;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebrowSetEx {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Load JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "oraclehr");
			// Create JdbcRowSet object
			WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();
	        wrs.setCommand("SELECT * FROM EMPLOYEES");
	        wrs.execute(conn);
	        
	        wrs.writeXml(new FileOutputStream("employees.xml"));
		}catch(Exception x) {
			x.printStackTrace();
		}
		
	}	
}
