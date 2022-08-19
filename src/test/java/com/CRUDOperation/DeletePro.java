package com.CRUDOperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeletePro {
	@Test
	public void delete() {
		RestAssured.delete("http://localhost:8084/projects/TY_PROJ_203");
	}
}