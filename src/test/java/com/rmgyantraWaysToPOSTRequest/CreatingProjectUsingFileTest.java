package com.rmgyantraWaysToPOSTRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
public class CreatingProjectUsingFileTest {
@Test
public void createproject() {
File f=new File("");
given()
.contentType(ContentType.JSON)
.body(f)
.when()
.post("http://localhost:8084/addProject")
.then()
.log()
.all();
}
}