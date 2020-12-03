package com.StepDefinations;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.pojo.AddPlace;
import com.resources.APIResources;
import com.resources.GenericMethods;
import com.resources.TestDataBuild;
import com.resources.Utils;

//comments added

public class StepDefination extends GenericMethods {
	RequestSpecification req;
	ResponseSpecification resSpec;
	Response resp;
	static String actPalceId;
	@Given("When payload is loaded {string} {string} {string}")
	public void when_payload_is_loaded(String name, String language, String address) throws IOException {
		AddPlace ap = TestDataBuild.addPlacePayLoad(name, language, address);
		req = given().spec(requestBuilder()).body(ap);
	}

	@When("User {string} with {string} http request")
	public void user_with_http_request(String resource, String httpReq) {
		APIResources res=APIResources.valueOf(resource);
		if(httpReq.equalsIgnoreCase("post"))
		{
		resp = req.when().post(res.getResource());
		}
		if(httpReq.equalsIgnoreCase("get")){
			
			resp = req.when().get(res.getResource());
			
		}
	}

	@Then("verify api calll success the status code {int}")
	public void verify_api_calll_success_the_status_code(Integer code) {
		resSpec = new ResponseSpecBuilder().expectStatusCode(code).build();
		if(code==200)
		{
			System.out.println("Api response code is valid");
		}
	}

	@Then("the {string} in reponse is {string}")
	public void in_reponse_is(String key, String value) {

		String actValue = getvalue(resp, key);
		compareTovalues(value, actValue);
	}
	
@Then("verify the place_Id created by api to {string} using {string}")
public void verify_the_place_Id_created_by_api_to_using(String name, String resource) throws IOException{
		 actPalceId = getvalue(resp, "place_id");
		req =given().spec(requestBuilder()).queryParam("place_id",actPalceId);
		
		user_with_http_request(resource,"get");
		String actValue = getvalue(resp, "name");
		compareTovalues(name, actValue);
		
		
	    
	}

@Given("When payload is loaded palce_id")
public void when_payload_is_loaded_palce_id() throws IOException
{
	req =given().spec(requestBuilder()).body(TestDataBuild.deletePalce(actPalceId));
	
	
	
  
}



	

}
