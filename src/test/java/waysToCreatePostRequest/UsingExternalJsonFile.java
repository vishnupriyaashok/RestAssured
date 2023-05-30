package waysToCreatePostRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class UsingExternalJsonFile {
	@Test
	public void exFile() throws FileNotFoundException {
		File f=new File(".//Body.json");
		FileReader fr =new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
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
