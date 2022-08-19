package com.CRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GettingProject {
	@Test
	public void gettingproject() {
		Response rsps=RestAssured.get("http://localhost:8084/projects");	
		//System.out.println(rsrp.asString());
		rsps.prettyPrint();
	}
}
