package switchBetweenTabsAndWindows;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchBetweenTabs {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.co.in/");
		Thread.sleep(3000);
		
		((JavascriptExecutor)driver).executeScript("window.open()");
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(1));
		driver.get("https://www.facebook.com/");
		Thread.sleep(3000);
		driver.switchTo().window(tabs.get(0));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.quit();

	}

}
