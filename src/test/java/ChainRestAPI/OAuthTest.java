package ChainRestAPI;

import static io.restassured.RestAssured.given;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class OAuthTest {

	@Test
	public void oauth() throws InterruptedException
	{
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\files\\chromedriver.exe");
//		WebDriver driver= new ChromeDriver();
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("manish.kapoor786786");
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("srinath19830");
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		String url= driver.getCurrentUrl();
		String urll="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWisoU-nemwlo0HoFW3nEGZ5jfD4nYpAcmp5A_rYqu9Se7Ff839BIJFfZbiZGNdaQw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=consent#";
		String url1= urll.split("code=")[1];
		String code= url1.split("&scope")[0];
		
		String accessTokenResponse= given().urlEncodingEnabled(false).log().all()
		.queryParams("code",code)
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js= new JsonPath(accessTokenResponse);
		String access_token= js.getString("access_token");
		
		String response= given().log().all()
		.queryParam("access_token", access_token)
		
		.when().log().all()
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
	}
	
}
