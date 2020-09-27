package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqSpec;//we have to make this variable static so that we are telling that do not create another instance and use this single instance in the entire execution
	//so when you declare any variable as static  then that variable is shared across all your TC's in that particular execution
	
	
	public RequestSpecification requestspecification() throws IOException {
		
		if (reqSpec==null) {//here we are checking whether it has already have a knowledge of all the prerequisite or not
			
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));//creating a object of print stream class and crating a text file at runtime to log everything in that file
		//here we have given FileOutputStream because we have to write something in that file because the data is coming from outside 
		reqSpec=new RequestSpecBuilder().setBaseUri(GetGlobalValue("baseuri")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))//logging request details to a separate file
				.addFilter(ResponseLoggingFilter.logResponseTo(log))//logging request details to a separate file
				.setContentType(ContentType.JSON).build();
		return reqSpec;
		}
		return reqSpec;//to avoid the running of the block each and everytime for multiple test cases
	}
	
//	we have to extract the values from global.properties file so that we can use it 
	public static String GetGlobalValue(String key) throws IOException {
		
//		creating object for Properties class which is already present in java
		Properties prop= new Properties();
//		through this properties class object we can scan any file which have .properties extension
//		again you have to tell where your .properties file is exactly present
		FileInputStream fis=new FileInputStream("T:\\New Workspace\\APIFramework\\src\\test\\java\\Resources\\global.properties");//it is another class in java which will accept input file 
		//here we have given FileInputStream because file is already present here and only we need to read the values from that file
		
//		now prop object has knowledge of scanning any properties file fis object has knowledge of the location of the file
//		so we will integrate both the objects
		
		prop.load(fis);
		return prop.getProperty(key);//it will get the value present in global.properties according to the key at runtime and
		//it will return that value to the method
		
	}

}
