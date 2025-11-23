package seleniumWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// To add fluent wait, create object of WebDriverWait class
		Wait<WebDriver> wt = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("We can write custom message also")
				.ignoring(NoSuchElementException.class);

		// Launch website

		driver.get("https://www.registration.tools4testing.com/");

		// Click on the Login Button

		driver.findElement(By.id("loginopener")).click();

		// Focus on the dialog window by click on dialog window title

		WebElement loginWindow;

		loginWindow = wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-id-1\"]")));

		loginWindow.click();

		// Enter user name

		driver.findElement(By.id("loginUsername")).sendKeys("manu.m@tools4testing.com");

		// Enter user password

		driver.findElement(By.id("loginPassword")).sendKeys("hello");

		// Click on the Login Button

		driver.findElement(By.id("loginButton")).click();

		WebElement loginSuccessWindow;

		loginSuccessWindow = wt
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-id-3\"]")));

		loginSuccessWindow.click();

		driver.findElement(By.xpath("//*[@id=\"loginSuccessDialog\"]/div/span/input")).click();

		// close the driver

		driver.quit();
	}

}
