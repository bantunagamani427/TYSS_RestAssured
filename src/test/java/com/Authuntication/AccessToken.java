package com.Authuntication;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;



public class AccessToken {
	@Test
	public void accessToken() {
		Response rsps = given()
				.formParam("client_id", "SDET7HYD")
				.formParam("client_secret", "182db8f1e1b3a214a722ee6d4a94cc1c")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "https://example.com")
				.when()
				.post("http://coop.apps.symfonycasts.com/token");
		String token=rsps.jsonPath().get("access_token");
		System.out.println(token);
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3619)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
		.log().all();
	}
}
