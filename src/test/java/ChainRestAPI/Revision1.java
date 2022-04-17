package ChainRestAPI;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import files.Payload;
import files.Utils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import static org.junit.Assert.*;

public class Revision1 extends Utils {

	RequestSpecification request;
	Response response;
	String getResponse;
	String address;

	@Test
	public void addPlaceIDUsingPOST() {
		//POST METHOD
		request = given().log().all().spec(requestSpecs()).body(Payload.addPlace());
		response = request.when().log().all().post("/maps/api/place/add/json")
				.then().extract().response();
		String strResponse = response.asString();
		String place_id = jsonPathMethod(strResponse, "place_id");
		System.out.println(place_id);
		
		//GET METHOD
		request = given().log().all().spec(requestSpecs()).queryParam("place_id", place_id);
		getResponse = request.when().log().all().get("/maps/api/place/get/json")
				.then().extract().response().asString();
		address = jsonPathMethod(getResponse, "address");
		System.out.println("Before put command" +address);
		
		//PUT METHOD
		request = given().baseUri("https://rahulshettyacademy.com").log().all().body("{\r\n" + 
				"\"place_id\":\""+place_id+"\",\r\n" + 
				"\"address\":\"mani\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"");
		request.when().log().all().put("/maps/api/place/update/json")
		.then().assertThat().statusCode(200);
		
		//GET METHOD
		request = given().log().all().spec(requestSpecs()).queryParam("place_id", place_id);
		getResponse = request.when().log().all().get("/maps/api/place/get/json")
		.then().extract().response().asString();
		address = jsonPathMethod(getResponse, "address");
		System.out.println("after put command" +address);
	}

}
