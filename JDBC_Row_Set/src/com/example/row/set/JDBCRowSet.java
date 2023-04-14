package com.example.row.set;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			  Connection conn = null;
			  JdbcRowSet jdbcRowSet = null;

	        try {
	            // Load JDBC driver
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            // Establish connection
	            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "oraclehr");
	            // Create JdbcRowSet object
	            jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
	            jdbcRowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
	            jdbcRowSet.setUsername("HR");
	            jdbcRowSet.setPassword("oraclehr");
	            //jdbcRowSet.setCommand("SELECT * FROM CANDIDATE_PROFILE");
	            jdbcRowSet.setCommand("SELECT * FROM JOB_HISTORY");
	            jdbcRowSet.execute();
	            
	            
	            
	            ResultSetMetaData resultSetMetaData = jdbcRowSet.getMetaData();
	            
	            int count = resultSetMetaData.getColumnCount();
	            
	            while(jdbcRowSet.next()) {
	            	for(int i=1; i<=count;i++) {
	            		
	            		System.out.println(jdbcRowSet.getString(i)+"  ");
	            	}
	            	System.out.println("...........................");
	            }
	           //new ObjectOutputStream(new FileOutputStream("record.txt")).writeObject(jdbcRowSet);
	          System.out.println("Success ...  ");
	          
	        }catch (Exception e){
	        	e.printStackTrace();
	        }
	}

}
