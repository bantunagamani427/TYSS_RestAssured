package com.CRUDOperationbyBDD;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
public class GettingProjectGET {
@Test
public void getpro() {
when()//action part
.get("http://localhost:8084/projects")
.then()//validate
.assertThat()
.statusCode(200)
.log()
.all();
}
}
