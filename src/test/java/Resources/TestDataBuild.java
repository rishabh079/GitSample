package Resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.location;

public class TestDataBuild {
	
	
		public AddPlace AddPlacePayLoad(String name, String language, String address) {
			
			AddPlace place=new AddPlace();
			place.setAccuracy(40);
			
			place.setAddress(address); //driving the data from feature file
			place.setLanguage(language); //driving the data from feature file
			place.setName(name); //driving the data from feature file
			
			place.setPhone_number("(+91) 985 201 7217");
			place.setWebsite("http://www.rishabhAPI.com");	
			List <String> myList = new ArrayList<String>();		
			myList.add("shoe park");
			myList.add("shop");
			place.setTypes(myList);
			location l = new location();
			l.setLat(-35.383494);
			l.setLng(32.427362);
			place.setLocation(l);
			return place;
		}
}
