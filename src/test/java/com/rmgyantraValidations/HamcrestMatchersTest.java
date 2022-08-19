package com.rmgyantraValidations;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class HamcrestMatchersTest {
	@Test
	public void hamcrest() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		//System.out.println(rsps.get);
		.assertThat().time(Matchers.lessThan(5000l),TimeUnit.MILLISECONDS )
		.assertThat().body("[0].projectName", Matchers.equalTo("SDET_74"))
		.log()
		.all();
	}
}
