package mouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DoubleClick {

	public static void main(String[] args) throws Exception {

		// Launch the chrome browser instance
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/buttons");

		// double click on double click button
		WebElement doubleClkBtton = driver.findElement(By.id("doubleClickBtn"));
		Actions act = new Actions(driver);
		act.doubleClick(doubleClkBtton).perform();
		System.out.println("Double Click Done");
		String doubleClickMessage = "You have done a double click";
		WebElement msgText = driver.findElement(By.id("doubleClickMessage"));
		
		Assert.assertEquals(msgText.getText(), doubleClickMessage);
		System.out.println("Message Text Verified");
		
		driver.quit();
		
	}
}
