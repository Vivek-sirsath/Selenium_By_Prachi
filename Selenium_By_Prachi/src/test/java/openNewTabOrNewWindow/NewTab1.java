package openNewTabOrNewWindow;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTab1 {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Because using Selenium Version 4.15.0, below line won't work
		// Below line works fine when we use Selenium Version 3
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.selenium.dev/documentation/webdriver/interactions/windows/");
		
		Thread.sleep(3000);
		
		String clickl = Keys.chord(Keys.CONTROL,Keys.ENTER);
		
     	// open the link in new tab, Keys.Chord string passed to sendKeys
	     driver.findElement(By.linkText("Downloads")).sendKeys(clickl);
		
		Set<String> allWindowsID  = driver.getWindowHandles();
		System.out.println("All Windows ID:- " + allWindowsID.size());
		
		Iterator<String> abc = allWindowsID.iterator();
		String window1 = abc.next();
		String window2 = abc.next();
		
		driver.switchTo().window(window2);
		System.out.println("Title of 2nd Tab:- " + driver.getTitle());
		driver.close();
		
		driver.switchTo().window(window1);
		System.out.println("Switched to 1st window");
		
		System.out.println("Title of Original Window:- " + driver.getTitle());

	}

}
