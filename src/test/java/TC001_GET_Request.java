import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getuserDetails() {
		
		//Specify base URI
		RestAssured.baseURI="https://reqres.in";
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//resppnse object
		Response response=httprequest.request(Method.GET, "/api/users?page=2");
		
		//print response in console window
		String reponsebody=response.getBody().asString();
		System.out.println("Response body is: "+reponsebody);
		
		//status code validation
		int statuscode=response.getStatusCode();
		System.out.println("Status code is: "+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//status line verification
		String statusline=response.getStatusLine();
		System.out.println("Status line is: "+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

	}

}
