package waysToCreatePostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class UsingHashMap {
	@Test(priority=1)
	public void postReqUsingMap() {
		
		HashMap data= new HashMap();
		data.put("name","Jhony");
		data.put( "location","India");
		data.put("phone","1234567890");
		String course[]= {"pearl","selenium"};
		data.put("courses", course);
		
		given()
		 .contentType("application/json")
		 .body(data)
		
		.when()
		 .post("http://localhost:3000/students")
		.then()
		 .statusCode(201)
		 .body("name", equalTo("Jhony"))
		 .body("location",equalTo("India"))
		 .body("phone",equalTo("1234567890"))
		 .body("courses[0]",equalTo("pearl"))
		 .body("courses[1]",equalTo("selenium"))
		 .header("Content-Type", "application/json; charset=utf-8")
		 
		 .log().all();	 
	}
	
	@Test(priority=2,dependsOnMethods = "postReqUsingMap")
	public void delStu() {
		given()
		.when()
		.delete("http://localhost:3000/students/7")
		.then()
		.statusCode(200);
		
	}
	
	
	
	
	
	

}
