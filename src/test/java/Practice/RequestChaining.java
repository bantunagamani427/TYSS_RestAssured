package Practice;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChaining {
	@Test
	public void reqchain() {
		Response rsps = when().get("http://localhost:8084/projects");
		String projectID=rsps.jsonPath().get("[0].projectId");
		System.out.println("projectid from response"+projectID);
		given()
		.pathParam("proId", projectID)
		.when()
		.delete("http://localhost:8084/projects/{proId}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		


	}
}
