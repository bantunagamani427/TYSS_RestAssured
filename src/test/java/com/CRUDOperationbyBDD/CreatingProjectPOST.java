package com.CRUDOperationbyBDD;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class CreatingProjectPOST {
@Test
public void createpro() {
JSONObject jobj=new JSONObject();
jobj.put("createdBy", "NAGA");
jobj.put("projectName", "SDET_7HB");
jobj.put("status", "Created");
jobj.put("teamSize", 4);

given()
.contentType(ContentType.JSON)
.body(jobj)
.when()
.post("http://localhost:8084/addProject")
.then()
.assertThat().statusCode(201)
.log().all();
}
}
