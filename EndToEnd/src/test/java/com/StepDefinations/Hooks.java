package com.StepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlace")
	public void getPlaceid() throws IOException
	{
		StepDefination sd=new StepDefination();
		
		if(StepDefination.actPalceId==null)
		{
			sd.when_payload_is_loaded("Sachin","Kannada","beach street");
			sd.user_with_http_request("AddPlaceApi","Post");
			sd.verify_the_place_Id_created_by_api_to_using("Sachin","GetPPlaceApi");
			
		}
	}

}
