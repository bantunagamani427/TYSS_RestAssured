package Practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Delete {
@Test
public void deletePro() {
	when()
	.delete("http://localhost:8084/projects/TY_PROJ_1003")
	.then().log().all();
}
}
