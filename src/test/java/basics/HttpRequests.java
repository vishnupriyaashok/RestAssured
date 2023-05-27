package basics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
/*
 * given()
 * content type,set cookies,add auth,add param,set headers info etc
 * when() 
 * get,post,put,delete
 * then()
 * validate status code,extract response,extract headers cookies and response body
 */

public class HttpRequests {
	int id;

	@Test(priority = 1)
	public void gerUsers() {
		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	@Test(priority = 2)
	public void createUsr() {
		HashMap map = new HashMap();
		map.put("name", "abc");
		map.put("job", "teacher");

		id = given().contentType("application/json").body(map).when().post("https://reqres.in/api/users").jsonPath()
				.getInt("id");
		// .then()
		// .statusCode(201).log().all();
	}

	@Test(priority = 3, dependsOnMethods = { "createUsr" })
	public void updateUser() {
		HashMap map = new HashMap();
		map.put("name", "xyz");
		map.put("job", "actor");
		given().contentType("application/json").body(map).when().put("https://reqres.in/api/users/" + id).then()
				.statusCode(200).log().all();
	}

	@Test(priority = 4)
	public void deleteUser() {
		given().when().delete("https://reqres.in/api/users/" + id).then().statusCode(204).log().all();

	}

}
