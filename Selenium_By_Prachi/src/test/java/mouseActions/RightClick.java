package mouseActions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws Exception {
		
		// Launch the chrome browser instance
				System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   // Selenium 3
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Selenium 4
				driver.get("https://demoqa.com/buttons");
				
				// right(context) click on right click button
				WebElement rightClkBtton  = driver.findElement(By.id("rightClickBtn"));
				Actions act = new Actions(driver);
				act.contextClick(rightClkBtton).perform();
				System.out.println("Right Click Done");
							

	}



}
