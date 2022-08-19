package com.rmgyantraValidations;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponse {
	@Test
	public void staticvalidate() {

		String expdata="SDET_7";
		Response rsps=when()
				.get("http://localhost:8084/projects/TY_PROJ_202");
		String actualData=rsps.jsonPath().get("projectName");
		Assert.assertEquals(actualData,expdata);
		rsps.then().log().all();
	}
}

