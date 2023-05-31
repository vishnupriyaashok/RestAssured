package basics;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LogMethod {
	@Test
	public void TestLogMethod() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		//.log().cookies();
		.log().body()
		.log().headers();
	}

}
