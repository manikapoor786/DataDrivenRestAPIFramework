package ChainRestAPI;

import org.testng.annotations.Test;
import files.Payload;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.Matcher.*;
import io.restassured.RestAssured;

public class serializeTest {

	@Test
	public void testSerialize()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response= given().log().all()
		.queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(Payload.addPlace())
		
		.when()
		.post("/maps/api/place/add/json")
		
		.then().log().all()
		.assertThat().statusCode(200).body("scope", equalTo("APP"))
		.extract().response().asString();
		
		System.out.println(response);
	}
	
}
