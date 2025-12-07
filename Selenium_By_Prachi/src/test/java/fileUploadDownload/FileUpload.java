package fileUploadDownload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {

	public static void main(String[] args) throws AWTException {

		// Launch chrome browser
//		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");

//    1) Using sendKeys() method

//		 If 'type = file' is given then, we can upload file using sendKeys() method
//		 Else we've to use Robot Class to upload the file
//		 Locate 'Choose File' button and Upload a file		
//		 driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("C:\\Users\\Admin\\Desktop\\fileUpload.txt");

//    2) Using Robot Class and Actions Class

//      First we've to click on chooseBtn using Actions Class
		Actions act = new Actions(driver);
		WebElement chooseBtn = driver.findElement(By.xpath("//input[@id='uploadFile']"));		
		act.moveToElement(chooseBtn).click().perform(); 
//		File selection window will open, in this paste the file path which we want to upload
		
		
//      Create Robot Class object and add delay of 2 milliseconds
		Robot rb = new Robot();
		rb.delay(2000);
		
//		Copy file to clip-board using StringSelection Class
//		The 'ss' variable will pointing towards the file which we want to upload
		StringSelection ss = new StringSelection("C:\\Users\\Admin\\Desktop\\fileUpload.txt");	
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
//		Paste the file (Perform Cntrl+V)
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
//		Press and Release ENTER key
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("File Uploaded Successfully");
		
		driver.quit();
	}

}
