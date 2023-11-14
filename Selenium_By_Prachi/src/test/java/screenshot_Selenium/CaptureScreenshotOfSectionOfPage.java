package screenshot_Selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshotOfSectionOfPage {

	public static void main(String[] args) throws Exception {

		// Launch chrome browser
		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();

		// OpenUrl
		driver.get("https://demo.nopcommerce.com/");
		
		Thread.sleep(10000);
		

		// 2) Capture screenshot of SECTION of a page
		// Locate web element

		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));

		// STEP 1: Convert WebDriver object (driver) to TakesScreenshot Interface
//		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// STEP 2: Call getScreenshotAs() method to create image file
		File src = section.getScreenshotAs(OutputType.FILE);

		File dest = new File(
				".\\screenshots\\SectionScreenShot.png");

		// STEP 3: Copy source image file to destination using Apache Commons-IO
		FileUtils.copyFile(src, dest);
		
		driver.close();
	}

}
