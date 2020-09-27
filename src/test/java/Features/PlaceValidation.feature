Feature: Validating Place API

Scenario Outline: Verify if place is being successfully added using AddPlaceAPI

	Given Add place Payload with "<name>" "<language>" "<address>"
 	When user calls "addPlaceAPI" with "Post" http request 
	Then the API call is success with StatusCode 200
	And the "status" in response body is "OK"
	And the "scope" in response body is "APP"
	

#untill now data is hardcoded, which will be same everytime you run the test
#so we will implementing data driven mechanism
#we will dynamically drive three values in our test from feature file that is name, language and address

Examples: 
	| name    | language | address          |
	| AAHouse | English  | WorldCross Centre|
	| BBHouse | Hindi    | Sea Cross Centre |
	
	