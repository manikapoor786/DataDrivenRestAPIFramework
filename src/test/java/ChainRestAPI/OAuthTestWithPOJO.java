package ChainRestAPI;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.parsing.Parser;
import pojo.GetCourse;

public class OAuthTestWithPOJO {

	@Test
	public void oauth() throws InterruptedException
	{	
		GetCourse gc= given()
		.queryParam("access_token", "ya29.A0ARrdaM9euzhP73MDAZEHqSHKqfgfPlXhHoZShFzsVfxUYBhoZFquNskT0a3i2LUdXbjqyj-06F63uwg8y6FfLdM27DCeGeF8XN8ZSFyvhUMFzMiFVzmkm5mpVJLTa5G6AGypHKJSK2iulo4VFAa_mx7Q75FxQA").expect().defaultParser(Parser.JSON)
		
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);

		System.out.println(gc.getInstructor());
		
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	}
}
