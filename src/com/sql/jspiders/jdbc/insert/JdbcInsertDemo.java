package com.sql.jspiders.jdbc.insert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcInsertDemo {
   private static Connection connection;
   private static Statement statement;
   private static int result;
   private static FileReader fileReader;
   private static Properties properties;
   private static String query;
   private static String filePath="C:\\WEJA1\\JDBC\\Resource\\db_info.properties";
 
      public static void main(String[] args) {
		 try {
			fileReader = new FileReader(filePath);
			properties = new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverPath"));
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			statement =connection.createStatement();
			query= "insert into employee values"+"(7,'Rahul','rahul123@gmail.com')";
			result= statement.executeUpdate(query);
			System.out.println("query is ok"+result+"row(s) affected");
			
			
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
