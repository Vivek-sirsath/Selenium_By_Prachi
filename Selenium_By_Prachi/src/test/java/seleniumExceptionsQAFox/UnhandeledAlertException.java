
/* UnhandeledAlertException : If we try to do other operations without handling the alert
   then, this exception will come.
   
   To fix this issue: Handle the alert first before performing any other operation.
*/

package seleniumExceptionsQAFox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnhandeledAlertException {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");
		
		driver.findElement(By.id("alert1")).click();
		driver.findElement(By.id("ta1")).sendKeys("Vivek");
		
//		Here, sendKeys() will not work.
//		If we try to do other operations without handling the alert
//		then 'org.openqa.selenium.UnhandledAlertException' comes
		
        driver.close();
	}

}
