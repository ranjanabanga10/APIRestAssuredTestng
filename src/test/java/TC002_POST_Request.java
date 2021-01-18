import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	@Test
	void createuserDetails() {
		
		//Specify base URI
		RestAssured.baseURI="https://reqres.in";
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		
		//Request payload sending along with post request
		
		JSONObject requestparams=new JSONObject();
		requestparams.put("name	", "morpheus");
		requestparams.put("job", "leader");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparams.toJSONString());
		
		//Response object
		Response response=httprequest.request(Method.POST, "/api/users");

		//print response in console window
		String reponsebody=response.getBody().asString();
		System.out.println("Response body is: "+reponsebody);
		
		//status code validation
		int statuscode=response.getStatusCode();
		System.out.println("Status code is: "+statuscode);
		Assert.assertEquals(statuscode, 201);
		
		String job=response.jsonPath().get("job");
		Assert.assertEquals(job, "leader");

	}

}
