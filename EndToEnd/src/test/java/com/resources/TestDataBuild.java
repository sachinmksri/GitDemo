package com.resources;

import java.util.ArrayList;
import java.util.List;

import com.pojo.AddPlace;
import com.pojo.Location;

import io.restassured.RestAssured;

public class TestDataBuild {

	public static AddPlace addPlacePayLoad(String name, String language, String address){
		
	List<String> ls = new ArrayList<String>();
	ls.add("shoe park");
	ls.add("shop");
	Location loc = new Location();

	loc.setLat(33.427362);
	loc.setLng(-38.383494);
	//RestAssured.baseURI = "https://rahulshettyacademy.com";
	AddPlace ap = new AddPlace();
	ap.setAccuracy(50);
	ap.setName(name);
	ap.setPhone_number("(+91) 983 893 3937");
	ap.setAddress(address);
	ap.setWebsite("http://google.com");
	ap.setLanguage(language);
	ap.setTypes(ls);
	ap.setLocation(loc);
	
	return ap;
	}
	
	public static String deletePalce(String actPalceId)
	{
		
		return "{\r\n" + 
				"    \"place_id\":\""+actPalceId+"\"   	 	\r\n" + 
				"}\r\n" + 
				"";
	}
}
