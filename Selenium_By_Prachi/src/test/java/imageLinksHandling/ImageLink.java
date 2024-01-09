/* 1) Image links are the links on web pages represented by an image,
 *    when we click on that image, it will lead us to a Web Page or Home Page
 * 2) Only cssSelector or XPath can be use to locate the Image Links
 * 3) We cann't use - By.linkText() or By.partialLinkText() methods,
 *    because image links don't have linkText associated to the links
 *    like the other links have.
 */

package imageLinksHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageLink {

	public static void main(String[] args) {

//      Launch chrome browser
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.opencart.com/index.php?route=common/home");
		
//		Locate Image Link
		driver.findElement(By.xpath("//img[@title='OpenCart - Open Source Shopping Cart Solution']")).click();
		
//		Expected title of web page
		String expectedTitle = "OpenCart - Open Source Shopping Cart Solution";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		driver.close();
	}

}
