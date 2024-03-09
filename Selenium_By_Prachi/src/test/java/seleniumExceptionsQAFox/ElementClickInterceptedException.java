
/* ElementClickInterceptedException: This exception occurs when other UI elements 
   hides the UI element to be clicked during Selenium automation.
   Hiding means, e.g. 
          The Blog menu when clicked, its drop down menu will open up and overlaps 
          or covers the link, which we want to click.
          i.e. In GUI one element is cover up by another element during automation.
          Such that the element will not be visible to locate.
*/

package seleniumExceptionsQAFox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementClickInterceptedException {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");
		driver.findElement(By.id("blogsmenu")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("selenium143")).click();
//		Here, the link is overlapped by the Blog menu options. So, link will not get clocked.
//		throwing the exception 'org.openqa.selenium.ElementClickInterceptedException' at Line No. 25

		driver.close();
	}

}
