package seleniumExceptionsQAFox;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoAlertPresentException {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");

//		driver.findElement(By.id("alert1")).click();

		Alert al = driver.switchTo().alert(); // Exception at this line
//		If we don't click on alert link, we can't switch to alert though alert is not present
//		then, 'org.openqa.selenium.NoAlertPresentException' will throw.

		al.accept();

		driver.close();

	}

}
