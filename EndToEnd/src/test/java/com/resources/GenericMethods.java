package com.resources;

import java.io.IOException;

import com.pojo.AddPlace;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GenericMethods extends Utils
{

	public RequestSpecification requestBuilder() throws IOException
	{
		
		RequestSpecification reqSpec= new RequestSpecBuilder().setContentType("application/json").
				setBaseUri(getQAUrl()).addQueryParam("key", "qaclick123").build();
		//reqSpec.header("aaa","aaa");
		return reqSpec;
	}
	
	public String getvalue(Response resp, String key)
	{
		
		String req=resp.asString();
		JsonPath js=new JsonPath(req);
		String actValue=js.get(key);
		return actValue;
		
	}
	
	public void compareTovalues(String expeted, String Actual)
	{
		
		if(expeted.equalsIgnoreCase(Actual))
		{
			System.out.println("Expected value "+expeted+" Matched with actual value "+Actual);
		}
		else{
		System.out.println("Expected value is not "+expeted+" Matched with actual value "+Actual);
		}
		
		
	}
	
	
}
