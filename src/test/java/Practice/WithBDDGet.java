package Practice;

import static io.restassured.RestAssured.when;

import io.restassured.http.ContentType;
public class WithBDDGet {
	public static void main(String[] args) {

	when()
	.get("http://localhost:8084/projects")
	.then()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON)
	.log().all();
}
}
