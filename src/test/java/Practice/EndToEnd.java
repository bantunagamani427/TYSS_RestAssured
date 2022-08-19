package Practice;
import static io.restassured.RestAssured.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.rmgyantra.GenericUtility.JavaUtility;
import com.rmgyantraPOJOLibrary.POJO;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEnd {
	@Test
	public void endtoend() throws SQLException {
		JavaUtility jUtil=new JavaUtility();
		POJO p=new POJO("SrimanRam1", "RMG_Hyd_234"+jUtil.generateRandomData(), "created", 4);

		Response rsps = given()
				.contentType(ContentType.JSON)
				.body(p)
				.when()
				.post("http://localhost:8084/addProject");

		String projectID = rsps.jsonPath().get("projectId");

		Response rsps1 = given()
				.pathParam("proId", projectID)
				.when()
				.get("http://localhost:8084/projects/{proId}");
		String projectNAME=rsps1.jsonPath().get("projectName");
		System.out.println("actual projectname "+projectNAME);

		
		//=DriverManager.getConnection("");


	}

}
