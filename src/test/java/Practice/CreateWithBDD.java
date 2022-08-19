package Practice;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateWithBDD {
@Test
public void createpro() {
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy","mama");
	jobj.put("projectName","cooldrink");
	jobj.put("status","completed");
	jobj.put("teamSize",4);

	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.log()
	.all();
	
}
}
