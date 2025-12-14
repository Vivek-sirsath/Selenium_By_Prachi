package seleniumExceptionsQAFox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementNotInteractableException {

	public static void main(String[] args) {
		
		
//		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
//		Exception in thread "main" org.openqa.selenium.SessionNotCreatedException: Could not start a new session. 
//		Response code 500. 
//		Message: session not created: This version of ChromeDriver only supports Chrome version 131
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		Case: 1 - Text of Login Window
//		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");		
//		driver.findElement(By.xpath("//h2[text()='Returning Customer']")).sendKeys("Vivek");
//		As we try to interact with the element on the web page,
//		But if we can't interact with it, then exception comes 
//		'org.openqa.selenium.ElementNotInteractableException'
		
//		Case: 2 - SearchBox 
//		driver.get("https://omayo.blogspot.com");
		// find text field (Search This Blog) 
//		driver.findElement(By.className("gsc-input")).sendKeys("Vivek");
		
//		Case: 3 - Hidden Button
//		'Hidden Button' attribute is there but, Actually button is not visible.
		driver.get("https://omayo.blogspot.com");
		// Click on Disable-Enable Button - (My Button)
		driver.findElement(By.id("hbutton")).click();
		
	}

}
