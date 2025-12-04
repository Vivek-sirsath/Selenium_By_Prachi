package allAlerts;

import java.time.Duration; // Slenium 4
import java.util.concurrent.TimeUnit; // Selenium 3

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleConfirmationPromptAlerts {

	public static void main(String[] args) throws InterruptedException {

		// Launch the chrome browser instance
		// System.setProperty("webdriver.chrome.driver",
		// "E:\\EDUCATIONAL\\chromedriver.exe");
		// If the path of 'chromedriver.exe' doesn't match then,
		// Exception in thread "main" org.openqa.selenium.remote.NoSuchDriverException:
		// chromedriver located at
		// E:\EDUCATIONAL\chromedriver.exe, but invalid

//		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Selenium
		// 3
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Selenium 4

		// Domain and Locators changed 
		// 'http://uitestpractice.com/Students/Switchto' --> 'http://uitestingplayground.com/alerts'
		// //button[@id='alert'] --> //button[@id='alertButton']
		// //button[@id='confirm'] --> //button[@id='confirmButton']
		// //button[@id='prompt'] --> //button[@id='promptButton']
		
		driver.get("http://uitestingplayground.com/alerts");

		// click on simple alert button
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Thread.sleep(3000);
		// Switch to alert to Accept
		driver.switchTo().alert().accept();
		System.out.println("1. Simple Alert Verified");
		Thread.sleep(3000);

		// case 1 - Confirmation alert - OK
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept(); // OK button will click
		System.out.println("Confirmation alert accepted");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		System.out.println("Confirmation alert of 'Yes' accepted");
		System.out.println("2. OK - Confirm Alert Verified");

		Thread.sleep(3000);

		// case 1 - Confirmation alert - CANCEL
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss(); // OK button will click
		System.out.println("Confirmation alert accepted");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		System.out.println("Confirmation alert of 'NO' accepted");
		System.out.println("2. CANCEL - Confirm Alert Verified");

		// click on prompt alert
		driver.findElement(By.xpath("//button[@id='promptButton']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Steve");
		Thread.sleep(6000);
		driver.switchTo().alert().accept();
		System.out.println("First prompt alert accepted");
		Thread.sleep(3000);
		// Switch to second alert
		driver.switchTo().alert().accept();
		System.out.println("Second prompt alert accepted");
		Thread.sleep(4000);
		System.out.println("3. Prompt Alert Verified");

		driver.quit();
	}

}
