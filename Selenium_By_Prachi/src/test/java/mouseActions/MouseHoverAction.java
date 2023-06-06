package mouseActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) throws Exception {
		
		// Launch the chrome browser instance
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ianlunn.github.io/Hover/");
		
		WebElement hvr1 = driver.findElement(By.linkText("Shutter In Horizontal"));
		WebElement hvr2 = driver.findElement(By.linkText("Shutter Out Horizontal"));
		WebElement hvr3 = driver.findElement(By.linkText("Shutter In Vertical"));
		WebElement hvr4 = driver.findElement(By.linkText("Radial In"));
		WebElement hvr5 = driver.findElement(By.linkText("Bounce To Right"));
		WebElement hvr6 = driver.findElement(By.linkText("Float Shadow"));
		WebElement hvr7 = driver.findElement(By.linkText("Bubble Float Top"));
		WebElement hvr8 = driver.findElement(By.linkText("Curl Top Left"));
		WebElement hvr9 = driver.findElement(By.linkText("Buzz"));
		
		
		Actions act = new Actions(driver);
		
		Thread.sleep(3000);
		
		act.moveToElement(hvr1).perform();
		Thread.sleep(2000);
		act.moveToElement(hvr2).perform();
		Thread.sleep(2000);
		act.moveToElement(hvr3).perform();
		Thread.sleep(2000);
		act.moveToElement(hvr4).perform();
		Thread.sleep(2000);
		act.moveToElement(hvr5).perform();
		Thread.sleep(2000);
		act.moveToElement(hvr6).perform();
		Thread.sleep(2000);
		act.moveToElement(hvr7).perform();
		Thread.sleep(2000);
		act.moveToElement(hvr8).perform();
		Thread.sleep(2000);
		act.moveToElement(hvr9).perform();
		
		Thread.sleep(6000);
		
		
		driver.close();
		

	}

}
