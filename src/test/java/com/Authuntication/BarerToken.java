package com.Authuntication;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class BarerToken {
@Test
public void barearToken() {
	given()
	.auth().oauth2("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")
	.when()
	.get("https://api.github.com/user/repos")
	.then()
	.log().all();
}
}
