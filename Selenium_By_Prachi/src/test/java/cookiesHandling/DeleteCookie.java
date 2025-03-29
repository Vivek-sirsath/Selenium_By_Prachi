package cookiesHandling;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCookie {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in");

		// Print no. of cookies before adding
		System.out.println("Number of cookies before adding :- " + driver.manage().getCookies().size());

		// Create Cookie
		Cookie cookieObj = new Cookie("TestCookie", "Vivek");
		// Add cookie to browser
		driver.manage().addCookie(cookieObj);

		Set<Cookie> allCookies = driver.manage().getCookies();

		// Print no. of cookies after adding
		System.out.println("Number of cookies after adding :- " + allCookies.size());
		
		System.out.println("-------------------------------------");

		for (Cookie cookie : allCookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}

		// Delete the added cookie
		driver.manage().deleteCookie(cookieObj);
		
		// Delete cookies by name
		driver.manage().deleteCookieNamed("i18n-prefs");
		driver.manage().deleteCookieNamed("session-id-time");
		driver.manage().deleteCookieNamed("csm-hit");
		
		System.out.println("-------------------------------------");

		// Print no. of cookies before adding
		System.out.println("Number of cookies after deleting :- " + driver.manage().getCookies().size());
		
		System.out.println("-------------------------------------");
		
		Set<Cookie> remainingCookies = driver.manage().getCookies();
		
		for (Cookie co : remainingCookies) {
			System.out.println(co.getName() + " : " + co.getValue());
		}

	}

}
