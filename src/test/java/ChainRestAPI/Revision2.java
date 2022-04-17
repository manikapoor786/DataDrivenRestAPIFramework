package ChainRestAPI;

import org.testng.annotations.Test;

import files.Payload2;
import files.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class Revision2 extends Utils{

	RequestSpecification requestSpecification;
	
	@Test
	public void revision2()
	{
		requestSpecification= given().log().all().spec(requestSpecs());
		
		JsonPath js= new JsonPath(Payload2.payload2());
		int size=js.get("courses.size()");
		
		//System.out.println(js.get("dashboard.purchaseAmount"));
		//System.out.println(js.get("courses[0].title"));
		
		for(int i=0;i<size;i++)
		{
			String title=js.get("courses["+i+"].title");
			//System.out.println(js.get("courses["+i+"].price"));
			if(title.equalsIgnoreCase("RPA"))
			{
				System.out.println(js.get("courses["+i+"].copies"));
				break;
			}
		}
	}
}
