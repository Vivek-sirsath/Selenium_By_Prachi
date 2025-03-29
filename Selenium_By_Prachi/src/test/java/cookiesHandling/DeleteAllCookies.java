package cookiesHandling;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteAllCookies {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in");
		
		// Print no. of cookies before deleting
		System.out.println("Number of cookies before deleting :- " + driver.manage().getCookies().size());

//		1) getCookies()   ---> Returns the list of all cookies.
		Set<Cookie> allCookies = driver.manage().getCookies();

		// Print no. of cookies
		System.out.println(allCookies.size());

		// Print all cookies
		for (Cookie cookie : allCookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}
		
		// Delete all cookies
		driver.manage().deleteAllCookies();
		
		// Print no. of cookies after deleting
		System.out.println("Number of cookies after deleting :- " + driver.manage().getCookies().size());

	}

}
