package cookiesHandling;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetSpecificCookieUsingName {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		
//      2) Get specific cookie according to name
		
		//System.out.println(driver.manage().getCookieNamed("session-id"));
		Cookie sessionID = driver.manage().getCookieNamed("session-id");
		System.out.println(sessionID);
		
		driver.quit();
	}

}
