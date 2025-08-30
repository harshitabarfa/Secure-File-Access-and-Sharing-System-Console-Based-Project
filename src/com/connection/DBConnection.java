package com.connection;
import java.sql.*;

public class DBConnection {
	String url = "jdbc:mysql://localhost:3306/batch14";
	String user = "root";
	String pass = "123456";
	
	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, user, pass);
	}
}
