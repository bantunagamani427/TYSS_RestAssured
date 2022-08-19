package com.rmgyantraValidations;
import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValidationTest {
@Test
public void dynamicValidation() {
	String expData="SDET_7";
	Response rsps=when()
	.get("http://localhost:8084/projects");
	List<String> list=rsps.jsonPath().get("projectName");
	for(String act:list) {
		if(expData.contains(act)) {
		System.out.println(act+" :project available");	
		break;
		}
	}
rsps.then().log().all();	
}
}
