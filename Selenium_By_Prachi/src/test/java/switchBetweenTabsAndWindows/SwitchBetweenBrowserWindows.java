package switchBetweenTabsAndWindows;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicTabbedPaneUI.TabSelectionHandler;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchBetweenBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.google.co.in/");
		Thread.sleep(3000);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.facebook.com/");
		
		ArrayList<String> windowIDs = new ArrayList<>(driver.getWindowHandles());
		System.out.println("No. of windows opened: " + windowIDs.size());
		System.out.println(windowIDs);
		driver.switchTo().window(windowIDs.get(0))
		.get("https://testautomationpractice.blogspot.com/");
		
		driver.quit();

	}

}
