// From orange pdf 
package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksAvailableOnWebPage {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		
		Thread.sleep(2000);
		
		List<WebElement> abc = driver.findElements(By.tagName("a"));
		int num = abc.size();
		System.out.println("Total no. of linkss: " + num);
		
		for (int i = 0; i <= num-1; i++) {
			String c = abc.get(i).getText();
			Thread.sleep(1000);
			System.out.println(c);
		}
	}

}
