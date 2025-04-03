
/* 
   SessionNotCreatedException: This exception throws if Browser version not compatible with Selenium version 
   Here, chromeDriver version used is: 113.0.5672.63 which is not compatible with browser version

   To fix this issue: We've to use latest dependency of 'WebdriverManager', add to pom.xml
*/

package seleniumExceptionsQAFox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SessionNotCreatedException {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); // Exception at this line
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		System.out.println(driver.getTitle());
		driver.close();

	}

}
