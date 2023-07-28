package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTestingClass2 {
	
	WebDriver driver;
	@Test
	public void verifyTitle() throws Exception {
		
		// Lauch chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");		
		
		// Enter UserName and Password
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		// Click on Login Button
		driver.findElement(By.id("login-button")).click();
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		
		driver.quit();	
		
		Thread.sleep(3000);
	}

}
