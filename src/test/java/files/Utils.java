package files;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Utils {

	static RequestSpecification requestSpec;
	static JsonPath js;
	
	public static RequestSpecification requestSpecs()
	{
		requestSpec = new RequestSpecBuilder()
					.setBaseUri("https://rahulshettyacademy.com")
					.addHeader("Content-type", "application/json")
					.addQueryParam("key", "qaclick123")
					.build();
		return requestSpec;
	}
	
	public static String jsonPathMethod(String strResponse, String responseAttribute)
	{
		js= new JsonPath(strResponse);
		String attribute= js.get(responseAttribute).toString();
		return attribute;
	}
}
