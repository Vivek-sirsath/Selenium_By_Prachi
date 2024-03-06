package seleniumNinja;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToHandleWindowsAndTabs {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pavantestingtools.com/");

		// Store the sequence of key-board events in a string
		String s = Keys.chord(Keys.CONTROL, Keys.ENTER);
		
		// Click on ISTQB-link
		driver.findElement(By.linkText("Online Training")).sendKeys(s);
		Thread.sleep(3000);
		
		// Get the window handles
		Set<String> windowsID=driver.getWindowHandles();
		
		// Iterate through windowsID
		Iterator<String> it = windowsID.iterator();
		String parent = it.next();
		String child = it.next();
		
		// Switch to parent window
		driver.switchTo().window(parent);
		System.out.println("Control switched to parent window");
		Thread.sleep(4000);
		
		// Switch to child window
		driver.switchTo().window(child);
		System.out.println("Control again switched to child window");
		Thread.sleep(5000);	

	}

}
