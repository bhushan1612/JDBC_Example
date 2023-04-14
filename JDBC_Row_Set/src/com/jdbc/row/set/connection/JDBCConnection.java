package com.jdbc.row.set.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

public class JDBCConnection {
	public static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		String fileName = "C:\\Users\\bhush\\Downloads\\JDBC_Row_Set\\src\\com\\jdbc\\row\\set\\connection\\JDBCConnection";
		File file  = new File(fileName);
		InputStream in = new FileInputStream(file);
		prop.load(in);
		in.close();
		return prop;
	}

	public static void main(String[] args) {

		JDBCConnection connection = new JDBCConnection();
		connection.getConnection();
	}
	
	public void getConnection() {

		System.out.println("create jdbc connection using properties file");
		Connection con = null;

		try {

			Properties prop = loadPropertiesFile();

			String driverClass = prop.getProperty("JDBC.driver");
			String url = prop.getProperty("JDBC.url");
			String username = prop.getProperty("JDBC.username");
			String password = prop.getProperty("JDBC.password");

			Class.forName(driverClass);

			con = DriverManager.getConnection(url, username, password);
					
			  Statement stmt = con.createStatement();
		      ResultSet rs = stmt.executeQuery("SELECT * from CANDIDATE_PROFILE");
		      while(rs.next()) {
		    	 int number = rs.getInt("CANDIDATE_ID") ;
		         String fname = rs.getString("FNAME");
		         String lname = rs.getString("LNAME");
		         Blob blob = rs.getBlob("CANDIDATE_PICTURE");
		         Clob clob = rs.getClob("CANDIDATE_RESUME");
		         String dob = rs.getString("CANDIDATE_DOB");
		         Date cpd = rs.getDate("CADIDATE_PROFILE");
		         
		         System.out.println("ID: "+number);
		         System.out.println("First Name: "+fname);
		         System.out.println("Last Name: "+lname);
		         System.out.println("Blob value: "+blob.toString());
		         System.out.println("Clob value: "+clob.toString());
		         System.out.println("DOB value: "+dob);
		         System.out.println("Profile value: "+cpd);
		        
		         System.out.println("");
		         	File clobFile = new File("clob_" + number + ".doc");
		            OutputStream clobOs = new FileOutputStream(clobFile);
		            File blobFile = new File("blob_" + number + ".png");
		            OutputStream blobOs = new FileOutputStream(blobFile);
		            
		            // Write CLOB data to file
		            Reader clobReader = clob.getCharacterStream();
		            char[] cbuf = new char[1024];
		            int len;
		            while ((len = clobReader.read(cbuf)) != -1) {
		                clobOs.write(new String(cbuf, 0, len).getBytes());
		            }
		            
		            // Write BLOB data to file
		            InputStream blobIs = blob.getBinaryStream();
		            byte[] bbuf = new byte[1024];
		            while ((len = blobIs.read(bbuf)) != -1) {
		                blobOs.write(bbuf, 0, len);
		            }
		            
		            // Close file output streams and readers
		            clobOs.close();
		            blobOs.close();
		            clobReader.close();
		            blobIs.close();
		        }
		}catch (Exception e) {
			// TODO: handle exception
			   e.printStackTrace();
		}
	}
}