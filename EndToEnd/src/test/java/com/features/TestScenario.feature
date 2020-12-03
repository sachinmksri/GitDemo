Feature: Place API integartion testcases

@AddPlace
Scenario Outline: Verify the API can able to add/get places 
Given When payload is loaded "<Name>" "<Address>" "<Language>"
When User "AddPlaceApi" with "post" http request 
Then verify api calll success the status code 200
And the "status" in reponse is "OK"
And the "scope" in reponse is "APP"
And verify the place_Id created by api to "<Name>" using "GetPPlaceApi"

Examples:
|Name|Address|Language|
|Sachin|24 cross street|Franch|

@DeletePlace
Scenario: Verify the API can able to delete places 
Given When payload is loaded palce_id
When User "DeletePlaceApi" with "post" http request 
Then verify api calll success the status code 200
And the "status" in reponse is "OK"
