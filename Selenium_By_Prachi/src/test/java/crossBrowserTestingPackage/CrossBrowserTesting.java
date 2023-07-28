package crossBrowserTestingPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {

	WebDriver driver;

	// We need to assign Browser-Value to the parameter browser 	
	// of LaunchBrowser method
	// For this we need to use parameter annotation
	@BeforeMethod
	@Parameters("browser") // Here the value of browser come from testng.xml file
	public void launchBrowser(String browser) {

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			driver = null;
			break;

		}
	}

	@Test
	public void verifyTitle() {
		driver.get("http://www.google.com");

		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
