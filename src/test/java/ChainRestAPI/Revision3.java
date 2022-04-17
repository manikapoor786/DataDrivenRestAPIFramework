package ChainRestAPI;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import files.Payload;
import files.Utils;
import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Revision3 extends Utils{
	
	JsonPath js;
	RequestSpecification request;

	@Test
	public void E2E()
	{
		String response = given().log().all().spec(requestSpecs()).body(Payload.addPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().toString();
		
		JsonPath js= new JsonPath(response);
		
		String PlaceID = js.get("place_id");
		System.out.println(PlaceID);
	}
}
