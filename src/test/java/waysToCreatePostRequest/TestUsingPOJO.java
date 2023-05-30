package waysToCreatePostRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TestUsingPOJO {
	
	@Test
	
	public void testPojo() {
	UsingPOJO data=new UsingPOJO();
	data.setName("Scott");
	data.setLocaion("France");
	data.setPhone("0987654321");
	String course[]= {"python","testNg"};
	data.setCourses(course);
	
	given()
	 .contentType("application/json")
	 .body(data)
	
	.when()
	 .post("http://localhost:3000/students")
	.then()
	 .statusCode(201)
	 
	 .header("Content-Type", "application/json; charset=utf-8")
	 
	 .log().all();
	
}
}