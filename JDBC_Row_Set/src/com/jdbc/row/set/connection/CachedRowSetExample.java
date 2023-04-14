package com.jdbc.row.set.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetExample {
    public static void main(String[] args) {
        Connection conn = null;
        CachedRowSet rowSet = null;

        try {
            // Load JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "Admin");

            // Create CachedRowSet object
            RowSetFactory factory = RowSetProvider.newFactory();
            rowSet = factory.createCachedRowSet();
            rowSet.setCommand("SELECT * FROM EMPLOYEES");
            rowSet.execute(conn);

            // Update data
            rowSet.absolute(2);
            rowSet.updateString("FIRST_NAME", "John Doe");
            rowSet.updateRow();

            // Print data
            while (rowSet.previous()) {
                System.out.println(
                		rowSet.getInt("EMPLOYEE_ID") + "\t"
                	  + rowSet.getString("FIRST_NAME") + "\t"
                	  + rowSet.getDouble("salary"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection and row set
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rowSet != null) {
                try {
                    rowSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
