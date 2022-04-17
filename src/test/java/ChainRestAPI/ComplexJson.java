package ChainRestAPI;

import org.testng.annotations.Test;

import files.Payload2;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	@Test
	public void complexJsonParse()
	{
		JsonPath jp= new JsonPath(Payload2.payload2());
		int count=jp.getInt("courses.size()");
		//System.out.println(jp.getInt("dashboard.purchaseAmount"));
		//System.out.println(jp.getString("courses[0].title"));
		
		for(int i=0;i<count;i++)
		{
			System.out.println(jp.getString("courses["+i+"].title"));
			System.out.println(jp.getInt("courses["+i+"].price"));
		}
	}
}
