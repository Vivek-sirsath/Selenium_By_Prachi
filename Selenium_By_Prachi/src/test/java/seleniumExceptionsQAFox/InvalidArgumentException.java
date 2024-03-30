
/*
 * InvalidArgumentException:
 * This exception comes, when we don't specify [http://] OR [https://] while providing Url in get();
 * e.g.
 *     driver.get("www.google.co.in"); // without protocol
 *     
 * To fix this issue: provide [http://] OR [https://] protocol in URL
 * e.g.
 *     driver.get("https://www.google.co.in");   
 */

package seleniumExceptionsQAFox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidArgumentException {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("www.omayo.blogspot.com"); // Exception at this line
	}

}
