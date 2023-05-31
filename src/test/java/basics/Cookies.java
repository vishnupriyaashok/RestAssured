package basics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {
	//@Test
	public void testCookies() {
		given().when().get("https://www.google.com").then()
				.cookie("NID", "https://www.google.com/webhp?hl=en&sa=X&ved=0ahUKEwic08mlnKD_AhXvm2oFHfkpASAQPAgJ")
				.statusCode(200);

	}
@Test
	public void getCookieInfo() {
		Response res = given().when().get(
				"https://www.google.com/search?q=google&oq=&aqs=chrome.0.69i59i450l8.171881908j0j15&sourceid=chrome&ie=UTF-8");
		//getting single cookie value
//		String cookieVal = res.getCookie("AEC");
//		System.out.println("value of AEC cookie is " + cookieVal);
		Map<String, String>cookieValues=res.getCookies();
		//System.out.println(cookieValues.keySet());
		for(String s:cookieValues.keySet()) {
			String c=res.getCookie(s);
			System.out.println(s+"  ---  "+c);
		}
	}

}
