
/*
 * NoSuchFrameException:
 * This exception occurs when we try switch to the frame that doesn't exist. 
 */

package seleniumExceptionsQAFox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchFrameException {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");
		
		// Try to Switch to the frame that doesn't exist.
		driver.switchTo().frame("abcd"); // Exception at this line.

	}

}
