package com.jdbc.row.set.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSetTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        JdbcRowSet rowSet = null;

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "oraclehr");

            // Create JdbcRowSet object
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
            rowSet.setUsername("HR");
            rowSet.setPassword("oraclehr");
            rowSet.setCommand("SELECT * FROM CANDIDATE_PROFILE");
            rowSet.execute();

            // Print data
            while (rowSet.next()) {
                System.out.println(
                		rowSet.getInt("CANDIDATE_ID") + "\t" 
                		+ rowSet.getString("FNAME") + "\t" 
                		+ rowSet.getString("LNAME") + "\t" 
                		+ rowSet.getBlob("CANDIDATE_PICTURE") + "\t" 
                		+ rowSet.getClob("CANDIDATE_RESUME") + "\t" 
                		+ rowSet.getString("CANDIDATE_DOB") + "\t" 
                		+ rowSet.getDate("CADIDATE_PROFILE"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close connection and row set
            if (conn != null) {
                conn.close();
            }
            if (rowSet != null) {
                rowSet.close();
            }
        }
    }
}
