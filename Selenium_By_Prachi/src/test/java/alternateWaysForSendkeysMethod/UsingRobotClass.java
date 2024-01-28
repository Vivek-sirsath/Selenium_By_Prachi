package alternateWaysForSendkeysMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingRobotClass {

	public static void main(String[] args) throws AWTException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");

		WebElement element = driver.findElement(By.name("q"));
		
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_SPACE);
		rob.keyRelease(KeyEvent.VK_SPACE);
		rob.keyPress(KeyEvent.VK_C);
		rob.keyRelease(KeyEvent.VK_C);
		rob.keyPress(KeyEvent.VK_A);
		rob.keyRelease(KeyEvent.VK_A);
		rob.keyPress(KeyEvent.VK_T);
		rob.keyRelease(KeyEvent.VK_T);
		
	}

}
