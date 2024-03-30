
/* IllegalStateException: 
   This exception comes when we don't set the driver path, before opening the browser using Selenium Automation.
   Selenium WebDriver talks to the Browser via driver, hence we've to set the driver path.
   
   To fix this issue: Use, 'System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");'
   [ But, why it is failing in my case? Instead of throwing exception, browser is launching ]
*/

package seleniumExceptionsQAFox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IllegalStateException {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

	}

}
