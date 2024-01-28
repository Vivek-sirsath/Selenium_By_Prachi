package alternateWaysForSendkeysMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UsingActionsClass {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");

		WebElement element = driver.findElement(By.name("q"));
		
		Actions act = new Actions(driver);
		act.sendKeys(element, "Flipkart").perform();
		Thread.sleep(3000);

	}

}
