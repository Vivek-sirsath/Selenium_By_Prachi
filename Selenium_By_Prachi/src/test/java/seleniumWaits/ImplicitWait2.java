package seleniumWaits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Stopwatch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait2 {

	public static void main(String[] args) {

		// Launch the chrome browser instance
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://cosmocode.io/automation-practice-handling-waits/");

//		If xpath is wrong, throws "NoSuchElementException"
//		If ImplicitWait is added, control will wait for the specified duration to throw the exception.
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Selenium 3.0
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Selenium 4.0
		
		Stopwatch watch = null;

		try {
			watch = Stopwatch.createStarted();
			driver.findElement(By.xpath("//input[@name='displayInpu']")).click();  // Wrong XPath
		} catch (Exception e) {
			watch.stop();
            System.out.println(e.getMessage());
            System.out.println("Elapsed time :- " + watch.elapsed(TimeUnit.SECONDS));
		}
	}

}
