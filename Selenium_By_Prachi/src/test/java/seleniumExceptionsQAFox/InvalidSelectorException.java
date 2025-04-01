
/*
 * InvalidSelectorException:
 * This exception comes, if we use wrong syntax for XPath or CSS Selector.
 * 
 * To fix this issue: Use valid syntax for XPath or CSS Selector
 */

package seleniumExceptionsQAFox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidSelectorException {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");
		driver.findElement(By.xpath("//input[@value='Search']]")).click(); // Exception at this line.
	}

}
