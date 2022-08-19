package com.rmgyantra.GenericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {
	
	public DataBaseUtility dUtil=new DataBaseUtility();
	
	@BeforeSuite
	public void connectTODB() throws SQLException {
		dUtil.createconnWithDB();
	}

	@AfterSuite
	public void closeConnectToDB() throws SQLException {
		dUtil.closeconnwithDB();
	}
}
