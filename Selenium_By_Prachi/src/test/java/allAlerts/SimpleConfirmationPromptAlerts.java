package allAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleConfirmationPromptAlerts {

	public static void main(String[] args) throws Exception {
		
		        // Launch the chrome browser instance
				System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("http://uitestpractice.com/Students/Switchto");
				
				
				// click on prompt alert
				driver.findElement(By.xpath("//button[@id='prompt']")).click();
				Thread.sleep(2000);
				driver.switchTo().alert().sendKeys("Ishita");
				Thread.sleep(6000);
				driver.switchTo().alert().accept();
				System.out.println("Prompt Alert Verified");
				Thread.sleep(3000);
				
				driver.navigate().refresh();
				
				// click on simple alert button
				driver.findElement(By.xpath("//button[@id='alert']")).click();
				Thread.sleep(3000);
				//Switch to alert to Accept
				driver.switchTo().alert().accept();
				System.out.println("Simple Alert Verified");
				Thread.sleep(3000);
				
				driver.navigate().refresh();
				
				// click on confirmation alert
				driver.findElement(By.xpath("//button[@id='confirm']")).click();
				Thread.sleep(3000);
				driver.switchTo().alert().accept(); // OK button will click
				//driver.switchTo().alert().dismiss(); // Cancel button will click
				System.out.println("Confirm Alert Verified");
				
				//driver.close();
	}

}
