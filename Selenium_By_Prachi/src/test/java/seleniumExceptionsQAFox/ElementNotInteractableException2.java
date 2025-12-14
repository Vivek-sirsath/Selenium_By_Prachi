package seleniumExceptionsQAFox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementNotInteractableException2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com");

		// Disabled Text Box

		try {
			WebElement disabledTextBox = driver.findElement(By.xpath("//input[@id='tb2']"));
			disabledTextBox.sendKeys("Welcome");
		} catch (Exception e) {
			System.out.println("Exception is : " + e.getMessage());
		} finally {
			System.out.println("Handling the ElementNotInteractableException");
		}
		
		System.out.println("Handled exception...");
		
		driver.quit();

	}

}
