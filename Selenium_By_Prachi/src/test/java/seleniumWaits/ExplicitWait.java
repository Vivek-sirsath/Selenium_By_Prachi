package seleniumWaits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://cosmocode.io/automation-practice-handling-waits/");
		
		// To add explicit wait, create object of WebDriverWait class
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
		// If we set time 10 Seconds - No exception
		// If we set time 2 Seconds - Exception comes
		
		Stopwatch watch = null;

		try {
			watch = Stopwatch.createStarted();
			driver.findElement(By.xpath("//input[@name='displayInput']")).click();
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']"))).sendKeys("Vivek");
			System.out.println("Text entered...");
			Thread.sleep(3000);
		} catch (Exception e) {
			watch.stop();
            System.out.println(e.getMessage());
            System.out.println("Elapsed time :- " + watch.elapsed(TimeUnit.SECONDS));
		}
		
		System.out.println("Successfully ended the program...");
        driver.quit();
	}

}
