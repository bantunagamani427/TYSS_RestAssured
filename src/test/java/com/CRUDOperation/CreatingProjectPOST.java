package com.CRUDOperation;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreatingProjectPOST {
@Test
public void creatingpro() {
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "Rishitha");
	jobj.put("projectName", "Rishi1");
	jobj.put("status", "On Going");
	jobj.put("teamSize",4);
	RequestSpecification rqspec=RestAssured.given();
	rqspec.contentType(ContentType.JSON);
	rqspec.body(jobj);
	
	Response rsps=rqspec.post("http://localhost:8084/addProject");
	 ValidatableResponse vres=rsps.then();
	 vres.assertThat().statusCode(201);
	 vres.log().all();
}
}