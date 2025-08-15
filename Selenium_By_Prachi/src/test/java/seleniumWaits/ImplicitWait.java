package seleniumWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {

		// Launch the chrome browser instance
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		Handling Exception by implicit wait
//		If 10 seconds wait is not given it throws "NoSuchElementException"

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Selenium 3.0
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Selenium 4.0
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
//		https://cosmocode.io/automation-practice-handling-waits/

		driver.findElement(By.xpath("//button[@id='btn2']")).click();
		String text = driver.findElement(By.xpath("//h3[normalize-space()='Show the textboxes here:']//input[@placeholder='Textbox2']")).getText();
		System.out.println(text); // Text is unable to get.

	}

}
