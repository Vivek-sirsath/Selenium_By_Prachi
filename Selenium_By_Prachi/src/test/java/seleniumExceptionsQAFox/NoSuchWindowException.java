
/*
 * NoSuchWindowException:
 * This exception occurs when we switch to the window that doesn't exist. 
 */

package seleniumExceptionsQAFox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchWindowException {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");
		
		// Store the Alphanumeric ID of default original window.
		String originalWindowID = driver.getWindowHandle();
		// open new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		// Print the Alphanumeric ID of Newly opened window
		System.out.println("New Window Id: " + driver.getWindowHandle());
		
		// Switch back to original window
		driver.switchTo().window(originalWindowID);
		System.out.println("Original Window Id: " + driver.getWindowHandle());
		
		// Try to switch to the window that doesn't exist.
		driver.switchTo().window("abcd");  // Exception at this line
		
	}

}
