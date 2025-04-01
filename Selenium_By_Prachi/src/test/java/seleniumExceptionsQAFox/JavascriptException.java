
/*
  JavascriptException:
  This exception comes if we use wrong syntax in JavaScript statements.
  
  To fix this issue: Use valid syntax for JavaScript statements.
 */

package seleniumExceptionsQAFox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptException {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");

		WebElement textAreaField1 = driver.findElement(By.id("ta1"));

		// using JavaScript enter the text in the 'textAreaField1'
		JavascriptExecutor jse = (JavascriptExecutor) driver; // Type Casting
		jse.executeScript("arguments[0.value = 'Vivek Sirsath'", textAreaField1); // Exception at this line

	}

}
