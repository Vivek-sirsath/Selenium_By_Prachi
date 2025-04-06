package seleniumExceptionsQAFox;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeoutException2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
//		If the application doesn't load in given time duration, we'll get an
//		exception - 'org.openqa.selenium.TimeoutException'
		driver.get("https://omayo.blogspot.com");

	}

}
