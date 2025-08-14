package parameterizedXPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParameterizedXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/flights");
		Thread.sleep(15000);
		/*
		 * // Below way we are repeating the code, just values in xpath are changing
		 * 
		 * driver.findElement(By.xpath("//a[text()='Hotels']")).click();
		 * Thread.sleep(5000);
		 * 
		 * driver.findElement(By.xpath("//a[text()='Flights']")).click();
		 * Thread.sleep(5000);
		 * 
		 * driver.findElement(By.xpath("//a[text()='Cars']")).click();
		 * Thread.sleep(5000);
		 */
		
		commonXPath(driver, "Tours"); // calling static method and passing the arguments.
		commonXPath(driver, "Hotels");
		commonXPath(driver, "Flights");
		
		driver.close();
	}
	
	// We need to declare the method static 
	// Because in static main method we can call static method directly by its Name
	public static void commonXPath(WebDriver driver, String value) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//a[text()='"+value+"']"));
		Thread.sleep(5000);
		element.click();
		
	}
}
