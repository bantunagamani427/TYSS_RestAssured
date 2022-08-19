package com.CRUDOperationbyBDD;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class Delete {
	@Test
	public void deletepro() {

		when()
		.delete("http://localhost:8084/projects/projectid")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}
