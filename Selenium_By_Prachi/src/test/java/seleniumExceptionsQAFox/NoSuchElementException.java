
/*
  NoSuchElementException: This exception mainly comes because of 3 reasons - 
  1) If incorrect locator is provided for web element.
  2) If the web element taking more delay in loading/rendering on the web page. Synchronization issue.
  3) If web element is inside an iFrame, and we try to perform operation on it without switching to iFrame.
  
 */

package seleniumExceptionsQAFox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementException {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://omayo.blogspot.com");

//		Case 1: If incorrect locator is provided for web element.
//		driver.findElement(By.id("ta123")).sendKeys("Vivek Sirsath"); // "ta1" // Exception line
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		Case 2: If the web element taking more delay in loading/rendering on the web page. Synchronization issue.
//		driver.findElement(By.className("dropbtn")).click();
//		driver.findElement(By.linkText("Flipkart")).click(); // Exception at this line
		
/*	    To fix the 2nd case:  is use Explicit Wait before clicking on 'Flipkart' option.		   	
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement flipkartLink = wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Flipkart")));
		flipkartLink.click();
*/		
    			
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
//		Case 3: If web element is inside an iFrame, and we try to perform operation on it without switching to iFrame.
		driver.get("https://the-internet.herokuapp.com/iframe");
//		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).clear(); // Exception at this line
		
/*		To fix the 3rd case: Switch to iFrame first, then clear()
 *      
*/
		
	}

}
