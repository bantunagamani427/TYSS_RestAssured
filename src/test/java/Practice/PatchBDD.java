package Practice;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchBDD {
@Test
public void partialUpadate() {
	JSONObject jobj=new JSONObject();
	jobj.put("projectName","ammamma");
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.patch("http://localhost:8084/projects/TY_PROJ_1003")
	.then()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.log().all();
}
}
