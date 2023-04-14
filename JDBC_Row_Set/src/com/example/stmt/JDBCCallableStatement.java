package com.example.stmt;

import java.sql.*;

public class JDBCCallableStatement {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Connect to the database
    	Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "HR";
        String password = "oraclehr";
        Connection conn = DriverManager.getConnection(url, user, password);
        
        // Create a CallableStatement object to call the stored procedure
        String procedureCall = "{call get_customer_info(?, ?, ?, ?, ?)}";
        CallableStatement cs = conn.prepareCall(procedureCall);
        
        // Set input parameters for the stored procedure
        int customerId = 1;
        cs.setInt(1, customerId);
        
        // Register output parameters for the stored procedure
        cs.registerOutParameter(2, Types.VARCHAR);
        cs.registerOutParameter(3, Types.VARCHAR);
        cs.registerOutParameter(4, Types.VARCHAR);
        cs.registerOutParameter(5, Types.VARCHAR);
        
        // Execute the stored procedure
        cs.execute();
        
        // Retrieve the output parameter values
        String customerName = cs.getString(2);
        String customerEmail = cs.getString(3);
        String customerPhone = cs.getString(4);
        String customerAddress = cs.getString(5);
        
        // Print the customer information
        System.out.println("Customer name: " + customerName);
        System.out.println("Customer email: " + customerEmail);
        System.out.println("Customer phone: " + customerPhone);
        System.out.println("Customer phone: " + customerAddress);
        
        // Close the CallableStatement and Connection objects
        cs.close();
        conn.close();
    }
}

