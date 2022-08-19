package com.rmgyantra.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	
public void createconnWithDB() throws SQLException {
	Driver dref=new Driver();
	DriverManager.registerDriver(dref);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
}
public void closeconnwithDB() throws SQLException {
	con.close();
}
public ResultSet executeQuery(String query) throws SQLException {
	Statement stmt = con.createStatement();
	ResultSet result = stmt.executeQuery(query);
	return result;
}
}
