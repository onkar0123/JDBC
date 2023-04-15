package com.sql.jspiders.jdbc.delete;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcDeleteDemo {
    
	private static Connection connection;
	private static Statement statement;
	private static FileReader fileReader;
	private static int result;
	private static Properties properties;
	private static String filePath ="C:\\weja1\\jdbc\\resource\\db_info.properties";
	private static String query;
	
	  public static void main(String[] args) {
		try {
			fileReader=new FileReader(filePath);
			properties= new Properties();
			properties.load(fileReader);
			
//			1.Load the Driver Class.
			
			Class.forName(properties.getProperty("driverPath"));
			
//			2.open the Connection.
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
			
//			3.Create Statement
			
			statement=connection.createStatement();
			query= "delete from employee where EmpID=7";
			
//			4.Process The Result
			
			result=statement.executeUpdate(query);
			System.out.println("query is ok\"+result+\"row(s) affected");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		finally {
			 try {
				 if (connection !=null) {
					 connection.close();
				 }
				 if (statement != null) {
					 statement.close();
				 }
				 if (fileReader !=null) {
					 fileReader.close();
				 }
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
	}
}
