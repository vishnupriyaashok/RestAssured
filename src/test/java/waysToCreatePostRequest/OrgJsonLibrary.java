package waysToCreatePostRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;


//post request body using Org.json body
//need to add library called org.json in pom
public class OrgJsonLibrary {
	@Test
	
	public void postUser() {
		JSONObject data=new JSONObject();
		data.put("name","JhonB");
		data.put( "location","India");
		data.put("phone","1234567890");
		String course[]= {"pearl","c#"};
		data.put("courses", course);
		
		
		given()
		 .contentType("application/json")
		 .body(data.toString())
		
		.when()
		 .post("http://localhost:3000/students")
		.then()
		 .statusCode(201)
		 .body("name", equalTo("JhonB"))
		 .body("location",equalTo("India"))
		 .body("phone",equalTo("1234567890"))
		 .body("courses[0]",equalTo("pearl"))
		 .body("courses[1]",equalTo("c#"))
		 .header("Content-Type", "application/json; charset=utf-8")
		 
		 .log().all();
	}
	

}
