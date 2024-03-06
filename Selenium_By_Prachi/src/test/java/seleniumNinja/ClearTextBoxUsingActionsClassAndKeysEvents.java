package seleniumNinja;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClearTextBoxUsingActionsClassAndKeysEvents {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Artemis");

		Actions act = new Actions(driver);
		act.click(driver.findElement(By.id("Wikipedia1_wikipedia-search-input")))
		.keyDown(Keys.CONTROL).sendKeys("a")
		.keyUp(Keys.CONTROL)
		.sendKeys(Keys.BACK_SPACE)
		.build() 	         
		.perform();
//		 Here, We're performing multiple sequence of operations, Hence we've to use build(),
//		 Else, we just have to use perform()
	}

}
