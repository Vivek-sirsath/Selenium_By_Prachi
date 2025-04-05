
/* 
   StaleElementReferenceException: This exception throws if the element become stale(Not Fresh)
   
   This comes if - The element has been removed from the DOM or the page has been refreshed after the element was located.
   The error occurs when an element that was previously found in the DOM is no longer valid. This usually happens when the page refreshes,
   updates dynamically, or the element gets detached from the DOM before an action (like sendKeys) is performed.
   
   1) If we locate the element and performed some action on it.
   2) Then after that, the page is changed or reloaded by any ways. Suppose we go to another page by link
   3) If we navigated back to previous page and used the already created reference object of that element
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

public class FixStaleElementReferenceException2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement textFieldArea = driver.findElement(By.id("name"));
		
		textFieldArea.sendKeys("Vivek Sirsath");
		
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		
		WebElement textFieldArea2 = driver.findElement(By.id("name"));
		
		textFieldArea2.sendKeys("Ishita Shirsath");
		Thread.sleep(3000);
		
		textFieldArea2.clear(); // Exception at this line will not come
		
		Thread.sleep(5000);
		
		driver.close();

	}

}
