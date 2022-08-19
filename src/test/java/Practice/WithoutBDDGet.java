package Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public abstract class WithoutBDDGet {
	public static void main(String[] args) {

		Response rsps = RestAssured.get("http://localhost:8084/projects");
		
		String completebody=rsps.prettyPrint();
		System.out.println("completebopdy="+completebody);
		
		//String body=rsps.asString();
		//System.out.println("body="+body);
		
		int statuscode =rsps.statusCode();
		System.out.println("statuscode="+statuscode);
		
		String contenttype = rsps.getContentType();
		System.out.println("contentType="+contenttype);
	}
}
