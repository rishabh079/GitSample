package Resources;
//enum is a special class in java which has collection of constants or methods
//we generally use this class when we need to declare any constant whichj we rarely change and API resource url are the values which rarely changes 
//we will use this special class in our framework to define the different resource uri's to avoid the hardcoding in our test scripts

public enum APIResources {
	
	addPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");

	private String resource;//global resource so that it can be used across the class
	 
	APIResources(String resource) {
	
		this.resource=resource;
	}
	
	public String getResource() {
	
		return resource;
	}
	
	//here we are directly returning the argument values when someone calls this method
	//so enum treats this as a method now, you need not have any body, parenthesis[{}] or return keyword to treat that as a method
	//and enum also encourages that if you have set of methods, all method you should declare at a time with a comma separation and at the end you can put semi-colon[;] to say that method declaration is over

	// it is mandatory to craeate a constuctor for using enum class methods
}
