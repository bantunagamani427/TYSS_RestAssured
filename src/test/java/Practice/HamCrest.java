package Practice;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class HamCrest {
	@Test
	public void hamcrest() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(500L), TimeUnit.MICROSECONDS)
		.log().all();

	}


}
