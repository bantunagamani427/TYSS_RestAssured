package End_To_End;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.rmgyantra.GenericUtility.BaseAPIClass;
import com.rmgyantra.GenericUtility.EndPoints;
import com.rmgyantra.GenericUtility.JavaUtility;
import com.rmgyantraPOJOLibrary.POJO;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class End2End extends BaseAPIClass{
	public Connection con;
	@Test
	public void end2end() throws SQLException {
		JavaUtility jUtil=new JavaUtility();
		POJO p=new POJO("SrimanRam", "RMG_Hyd_234"+jUtil.generateRandomData(), "created", 5);

		baseURI="http://localhost";
		port=8084;

		
		//creating  req
		Response rsps = given()
				.contentType(ContentType.JSON)
				.body(p)
				.when()
				. post(EndPoints.addProject);//no need to pass baseURI &Port it automatically takes
		String projectid=rsps.jsonPath().get("projectId");//get the path of projectid

		//proId can't make as global so that we are kept in pathParam for reusability
		Response rsps1 = given()
				.pathParam("proId",projectid)
				.when()
				.get(EndPoints.getSingleProject);//get created project

		String proName=rsps1.jsonPath().get("projectName");//in that project find path of projectname &store
		System.out.println("actualprojectname ="+proName);

		ResultSet result = dUtil.executeQuery("select * from project");//executeQuery
		
		while(result.next()) {
			if(proName.equals(result.getString(4))) {
				String projectname=result.getString(4);
				System.out.println(proName+": available in database");   
				break;
			}
			}
}
	}
