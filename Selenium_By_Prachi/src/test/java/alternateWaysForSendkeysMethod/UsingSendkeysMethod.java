package alternateWaysForSendkeysMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UsingSendkeysMethod {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		
		WebElement element = driver.findElement(By.name("q"));
		
		// 1st Way - Using sendKeys() method.
//		element.sendKeys("Amazon");
//		Thread.sleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		// 2nd WAY - Using Java script writing script in DOM console
		jse.executeScript("document.getElementsByName('q')[0].value='sendkeys'"); 
		driver.navigate().back();
		Thread.sleep(3000);
		
		// 3rd WAY - Using Java script By passing 'element' as reference to arguments	
		// Instead of 'document' we've to use 'argument'
//		jse.executeScript("argument[0].value='sendkeys'", element);
//		driver.navigate().back();
//		Thread.sleep(3000);
		
		// 4th WAY - By using Actions Class
//		Actions act = new Actions (driver);
//		act.sendKeys(element, "Another 3rd method");
		

	}

}
