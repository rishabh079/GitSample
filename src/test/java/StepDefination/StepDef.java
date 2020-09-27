package StepDefination;


import org.testng.Assert;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef extends Utils{


	Response response;
	int responsecode;
	String ResponseInString;
	RequestSpecification request;
	TestDataBuild data=new TestDataBuild();
	
	
	@Given("Add place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
		
		request=given().spec(requestspecification()).body(data.AddPlacePayLoad(name,language,address));//sending the data dynamically from feature file so that it will create the json request payload dynamically
    }

	@When("user calls {string} with Post http request")
	public void user_calls_with_Post_http_request(String resource) {
		
	   APIResources resourceAPI= APIResources.valueOf(resource);
	   System.out.println(resourceAPI.getResource());
	    
		response=request.when().post(resourceAPI.getResource()).then().extract().response();
	}

	@Then("the API call is success with StatusCode {int}")
	public void the_API_call_is_success_with_StatusCode(Integer int1) {
	    
				responsecode=response.getStatusCode();
				Assert.assertEquals(responsecode, 200);
	}

	@Then("the {string} in response body is {string}")
	public void the_in_response_body_is(String key, String value) {
		
				ResponseInString=response.asString();
				JsonPath js=new JsonPath(ResponseInString);
				Assert.assertEquals(js.get(key).toString(),value);
		
	}
	
}
