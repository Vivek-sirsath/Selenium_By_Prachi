
/* 
   StaleElementReferenceException: This exception throws if the element become stale(Not Fresh)
   1) Once we locate the element and performed some action on it.
   2) Then the page is changed or reloaded by any how. Suppose we go to another page by link
   3) If we navigated back to previous page an used the already created reference object of that element
      to locate and try to perform another action on it.
   4) Then, that reference will not work, we'll not able to perform operation on it.
   5) Rather, this will throw the exception of 'StaleElementReferenceException'

   To fix this issue: Always locate the element, after navigating the pages.
                      Do not use the already created WebElement reference objects.
*/

package seleniumExceptionsQAFox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementReferenceException {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement textFieldArea = driver.findElement(By.id("name"));
		
		textFieldArea.sendKeys("Vivek Sirsath");
		
		driver.findElement(By.linkText("open cart")).click();
		Thread.sleep(3000);		
		driver.navigate().back();
		
		textFieldArea.clear(); // Exception at this line

	}

}
