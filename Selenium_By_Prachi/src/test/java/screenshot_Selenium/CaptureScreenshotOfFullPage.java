package screenshot_Selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshotOfFullPage {

	public static void main(String[] args) throws IOException {

		// Launch chrome browser
		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();

		// OpenUrl
		driver.get("https://time.is/IST");

		// 1) Capture screenshot of FULL page 
 
		// STEP 1: Convert WebDriver object (driver) to TakesScreenshot Interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// STEP 2: Call getScreenshotAs() method to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir")+"\\screenshots\\FullPageScreenShot.png");

		// STEP 3: Copy source image file to destination using Apache Commons-IO
		FileUtils.copyFile(src, dest);
		
		driver.close();
			
	}

}
