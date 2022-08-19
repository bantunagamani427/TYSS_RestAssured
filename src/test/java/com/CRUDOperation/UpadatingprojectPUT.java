package com.CRUDOperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpadatingprojectPUT {
	@Test
	public void updatepro() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "nagamani");
		jobj.put("projectName","SDET_33");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 5);
		RequestSpecification rqsec = RestAssured.given();
		rqsec.contentType(ContentType.JSON);
		rqsec.body(jobj);
		Response rsps = rqsec.put("http://localhost:8084/projects/TY_PROJ_202");
		ValidatableResponse vres = rsps.then();
		vres.assertThat().statusCode(200);
		vres.log().all();
	}
}
