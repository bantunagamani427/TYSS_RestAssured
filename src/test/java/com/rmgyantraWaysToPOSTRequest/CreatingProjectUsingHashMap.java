package com.rmgyantraWaysToPOSTRequest;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatingProjectUsingHashMap {
	@Test
	public void creatingproject() {
		HashMap hp=new HashMap();	
		hp.put("createdBy", "Amma");
		hp.put("projectName", "SDET_77");
		hp.put("status","created");
		hp.put("teamsize", 8);
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log()
		.all();

	}


}
