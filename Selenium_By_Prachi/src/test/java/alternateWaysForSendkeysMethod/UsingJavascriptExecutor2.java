package alternateWaysForSendkeysMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingJavascriptExecutor2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");

		WebElement element = driver.findElement(By.name("q"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// 3rd WAY - Using Java script By passing 'elements' as reference to arguments
		// Instead of 'document' word we use 'argument'
		jse.executeScript("arguments[0].value='Flipkart'", element);
		
		driver.quit();
	}

}
