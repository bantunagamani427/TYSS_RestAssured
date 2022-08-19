package com.rmgyantraWaysToPOSTRequest;
import static io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantraPOJOLibrary.POJO;

import io.restassured.http.ContentType;

public class POJOUsing_DataProvider {
@Test(dataProvider="getData")
public void createmultipleproject(String createdBy, String projectName, String status, int teamSize) {
	POJO p=new POJO(createdBy, projectName, status, teamSize);
	given()
	.contentType(ContentType.JSON)
	.body(p)
	.when()
	.post("http://localhost:8084/addProject")
	.then()
	.log()
	.all();
}
@DataProvider
public Object[][] getData(){
	Object[][] objarr=new Object[2][4];
	objarr[0][0]="ramakrishna";//createdby
	objarr[0][1]="mobile";//projectname
	objarr[0][2]="created";//status
	objarr[0][3]=2;//teamsize
	
	objarr[1][0]="Shailu";//createdby
	objarr[1][1]="design";//projectname
	objarr[1][2]="Completed";//status
	objarr[1][3]=4;//teamsize
return objarr;
}
}
