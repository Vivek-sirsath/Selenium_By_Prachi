package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGReporterClass {

	WebDriver driver;
	
	@Test
	public void testNGReportUsingReporterClass() {
		
		// Launch browser
		WebDriverManager.chromedriver().setup();
		Reporter.log("Browser Launched...");
		
		//Instantiate WebDriver driver
		driver = new ChromeDriver();
		
		// Maximize browser window
		driver.manage().window().maximize();
		Reporter.log("Browser Maximized...");
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		// open URL
		driver.get("http://www.google.com/");
		Reporter.log("URL pened...");
		
		// Find search box web element
		WebElement searchBox = driver.findElement(By.name("q"));
		
		// Click and enter text in search box
		searchBox.sendKeys("Java");
		Reporter.log("Text Entered...");
		
		// Press Enter key
		searchBox.sendKeys(Keys.ENTER);
		Reporter.log("Enter Key Pressed...");
		
		
		
		
	}
}
