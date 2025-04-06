
/*
 * TimeoutException : In case of explicit wait of WebDriverWait 
 * This exception occurs when we try switch to the frame that doesn't exist. 
 */

package seleniumExceptionsQAFox;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeoutException1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");
		
//		Here we've to wait for alert getting displayed
//		sometimes, alert will not wait on time it might be delayed
//		So, in that case we've to wait explicitly until the alert getting displayed
		
//		driver.findElement(By.id("alert1")).click();
//		If we don't click on alert link,
//		then, 'org.openqa.selenium.TimeoutException' will come.
		
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		wt.until(ExpectedConditions.alertIsPresent()); // Exception at this line
		
		Alert al = driver.switchTo().alert();
		al.accept();
		
		driver.close();

	}

}
