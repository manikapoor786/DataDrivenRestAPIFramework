package ChainRestAPI;

import org.testng.annotations.Test;
import files.Payload;
import files.dataDriven;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.Matcher.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PutTest {
ArrayList<String> al= new ArrayList<String>();
	
	@Test
	public void testPut() throws IOException
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
		
		JsonPath path= new JsonPath(response);
		String placeId= path.getString("place_id");
		
		dataDriven dd= new dataDriven();
		al=dd.excelIntegration("Update Place");
		HashMap<String, Object> hm= new HashMap<String, Object>();
		hm.put("place_id", placeId);
		hm.put(al.get(0), al.get(1));
		hm.put(al.get(2), al.get(3));
		
		given().log().all()
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.header("Content-type","application/json")
		.body(hm)
		.when()
		.put("/maps/api/place/update/json")
		
		.then().log().all()
		.assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		given().log().all()
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.header("Content-type","application/json")
		
		.when()
		.get("/maps/api/place/get/json")
		
		.then().log().all()
		.assertThat().statusCode(200).body("address", equalTo("70 winter walk, USA"));
	}
}
