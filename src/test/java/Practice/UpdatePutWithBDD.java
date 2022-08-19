package Practice;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdatePutWithBDD {
	@Test
	public void update() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","deepak123");
		jobj.put("projectName","mama1933");
		jobj.put("status","completed");
		jobj.put("teamSize",4);

		
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.put("http://localhost:8084/projects/TY_PROJ_1003")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log()
		.all();
		System.out.println("upadated");
	}
}
