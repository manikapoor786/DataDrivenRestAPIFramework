package ChainRestAPI;

import org.junit.Test;

import files.Utils;
import io.restassured.RestAssured;
import pojo.PutLocation;
import pojo.SubLocation;
import pojo.locationResponse;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class Revision4 extends Utils {

	@Test
	public void testSerialization()
	{
		PutLocation p= new PutLocation();
		SubLocation s= new SubLocation();
		ArrayList<String> l= new ArrayList<String>();
		l.add("shoe park");
		l.add("shop");
		s.setLat(-38.383494);
		s.setLng(33.427362);
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setLocation(s);
		p.setTypes(l);
		
		locationResponse lr= given().log().all().spec(requestSpecs()).body(p)
		.when().log().all().post("/maps/api/place/add/json").as(locationResponse.class);
		
		System.out.println(lr.getPlace_id());
	}
}
