package alternateWaysForSendkeysMethod;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingJavascriptExecutor1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// 2nd WAY - Using Java script writing script in DOM console
		jse.executeScript("document.getElementsByName('q')[0].value='Amazon'");
		
		driver.quit();
	}
}
