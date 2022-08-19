package Practice;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CreateWithoutBdd {

	@Test
	public void createpro() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","deepak123");
		jobj.put("projectName","deepakPRO154");
		jobj.put("status","completed");
		jobj.put("teamSize",4);

		RequestSpecification rspece = given();
		rspece.contentType(ContentType.JSON);
		rspece.body(jobj);
		
		Response rsps = rspece.post("http://localhost:8084/addProject");
	
		String completebody=	rsps.prettyPrint();
		System.out.println("completebody="+completebody);
		
		int statuscode=rsps.statusCode();
		System.out.println("status code="+statuscode);
		
		String contenttype=rsps.getContentType();
		System.out.println("contentType="+contenttype);
		
		Assert.assertEquals(contenttype, "application/json");
		System.out.println("success");
	}

}
