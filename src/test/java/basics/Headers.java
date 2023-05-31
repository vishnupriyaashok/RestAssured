package basics;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;


public class Headers {
	//@Test
	public void testHeader() {
	given()
	.when()
	.get("https://www.google.com/search?q=google&oq=&aqs=chrome.0.69i59i450l8.171881908j0j15&sourceid=chrome&ie=UTF-8")
	.then()
	.header("Content-Type", "text/html; charset=ISO-8859-1")
	.header("Server","gws")
	.header("Cache-Control","private, max-age=0");
	}
	
	@Test
	public void testHeaders() {
		Response res=given()
		.when()
		.get("https://www.google.com/search?q=google&oq=&aqs=chrome.0.69i59i450l8.171881908j0j15&sourceid=chrome&ie=UTF-8");
		//getting single header value
		//String singleHeader=res.getHeader("Content-Type");
		
		//getting all header value
		io.restassured.http.Headers head=res.getHeaders();
		for(Header hd:head) {
			System.out.println(hd.getName()+"  "+hd.getValue());
		}
	}
	

	
}
