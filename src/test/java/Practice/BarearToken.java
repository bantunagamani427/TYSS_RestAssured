package Practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class BarearToken {
	@Test
	public void barearToken() {
		given()
		.auth().oauth2("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")
		.when()
		.get("http://github.com/user/repos")
		.then()
		.log()
		.all();
	}
}
