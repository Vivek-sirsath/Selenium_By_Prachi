package seleniumWaits;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class implicitWait {

	public static void main(String[] args) {
		
		// Launch the chrome browser instance
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Selenium 3.0
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // Selenium 4.0
		driver.get("https://testautomationpractice.blogspot.com/");
		
	}

}
