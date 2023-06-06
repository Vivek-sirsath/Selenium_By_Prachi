package formFilling;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormUsingActionsClass {

	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		// create action class reference and give the argument as driver
		Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("//input[@id='user-name']")))
		.click()
		.sendKeys("standard_user", Keys.TAB)
		.sendKeys("secret_sauce", Keys.ENTER)
		.build().perform();	
		 System.out.println("login successful");
		 Thread.sleep(2000);
		 driver.close();

	}
	

}
