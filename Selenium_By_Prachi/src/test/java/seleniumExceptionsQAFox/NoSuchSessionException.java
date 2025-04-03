
/*
 * NoSuchSessionException:
 * This exception occurs when the browser is closed, and we still try to run the code
 */

package seleniumExceptionsQAFox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchSessionException {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");
		driver.close();
		driver.getTitle(); // Exception at this line

	}

}
