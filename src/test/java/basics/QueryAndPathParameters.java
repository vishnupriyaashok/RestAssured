package basics;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

//https://reqres.in/api/users?page=2
public class QueryAndPathParameters {
	@Test
	void testQueryandPath() {
		given()
		.pathParam("Mypath", "users")
		.queryParam("page", 2)
		
		.when()
		.get("https://reqres.in/api/{Mypath}")
		.then()
		.statusCode(200);
		
		
	}

}
