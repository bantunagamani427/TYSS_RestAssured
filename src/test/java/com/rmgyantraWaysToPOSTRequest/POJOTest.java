package com.rmgyantraWaysToPOSTRequest;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import com.rmgyantraPOJOLibrary.POJO;

import io.restassured.http.ContentType;

public class POJOTest {
@Test
public void project() {
POJO p=new POJO("BANNU","SDET_4", "created", 10);
given()
.contentType(ContentType.JSON)
.body(p)
.post("http://localhost:8084/addProject")
.then()
.log()
.all();
}
}
