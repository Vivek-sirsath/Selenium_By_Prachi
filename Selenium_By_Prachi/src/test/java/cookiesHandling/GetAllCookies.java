package cookiesHandling;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllCookies {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in");

//		1) getCookies()   ---> Returns the list of all cookies.
		Set<Cookie> allCookies = driver.manage().getCookies();

		// Print no. of cookies
		System.out.println(allCookies.size());

		// Print each cookie
		for (Cookie cookie : allCookies) {
			System.out.println(cookie.getName() + " : " + cookie.getValue());
		}

//		i18n-prefs : INR
//		session-id-time : 2082787201l
//		ubid-acbin : 257-6636597-9603430
//		csm-hit : tb:s-JY8WWEYF22GMRDNMSX3S|1743178072443&t:1743178073642&adb:adblk_no
//		session-id : 261-8542737-5215238

		driver.quit();

	}

}
