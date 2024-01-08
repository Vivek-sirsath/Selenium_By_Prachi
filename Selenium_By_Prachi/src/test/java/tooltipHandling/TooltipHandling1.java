package tooltipHandling;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TooltipHandling1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   // Selenium 3
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Selenium 4
		driver.get("https://testautomationpractice.blogspot.com/");
		
		String actualTooltip = driver.findElement(By.id("age")).getAttribute("title"); 
		// getAttribute method will return the value of 'title' attribute
		System.out.println(actualTooltip);
		
		String expectedTooltip = "We ask for your age only for statistical purposes.";
		
		if(expectedTooltip.equalsIgnoreCase(actualTooltip)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}

	}

}
