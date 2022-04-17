package ChainRestAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*; 

public class Multipart {

	@Test
	public void multipart()
	{
		given().log().all().spec(requestSpecs())
	}
}
