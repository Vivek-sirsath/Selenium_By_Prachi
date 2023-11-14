package screenshot_Selenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshotofWebElement {

	public static void main(String[] args) throws Exception {
		
		// Launch chrome browser
				System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();

				// Maximize browser
				driver.manage().window().maximize();

				// OpenUrl
				driver.get("https://facebook.com/");
				
				Thread.sleep(5000);
				
				WebElement element = driver.findElement(By.xpath("//a[contains(@id,'u_0_0_')]"));
				
				File src = element.getScreenshotAs(OutputType.FILE);
				
				File dest = new File(".\\screenshots\\ElementScreenshot.png");
				
				FileUtils.copyFile(src, dest);
				
				driver.close();

	}

}
