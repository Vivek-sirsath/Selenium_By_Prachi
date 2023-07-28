package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestingClass1 {
	
	WebDriver driver;
	
	@Test
	public void verifyTitle() throws Exception {
		
		// Lauch chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		System.out.println("Title of WebPage: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		
		driver.quit();	
		
		Thread.sleep(3000);
	}
	
    @Test
	public void verifyLogo() throws Exception {
		
		// Lauch chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		WebElement logo = driver.findElement(By.xpath("//div[@class='login_logo']"));
		
		Thread.sleep(3000);
		
		Assert.assertTrue(logo.isDisplayed());
		
		driver.quit();
		
	}

}
