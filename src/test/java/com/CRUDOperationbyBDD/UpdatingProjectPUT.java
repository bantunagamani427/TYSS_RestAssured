package com.CRUDOperationbyBDD;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdatingProjectPUT {
	@Test
	public void updatepro() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","deepak123");
		jobj.put("projectName","deepakPRO1546");
		jobj.put("status","completed");
		jobj.put("teamSize",4);

		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1002")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
