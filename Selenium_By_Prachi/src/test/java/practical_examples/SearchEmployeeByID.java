package practical_examples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchEmployeeByID {

	public String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(baseURL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@AfterMethod(enabled = true)
	public void tearDown() throws InterruptedException {

		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	@Test
	public void searchEmployee() throws InterruptedException {

		String expEmployeeID = "01715";
		String actEmployeeID = "";

		// Find username and enter username "Admin"
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");

		// Find password and enter password admin123
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		// Login button click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		// Click on PIM menu
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

		Thread.sleep(3000);

		// Click on PIM menu
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

		Thread.sleep(3000);

		// Click on EmployeeList option
		driver.findElement(By.xpath("//a[normalize-space()='Employee List']")).click();

		// Enter First Name
		// driver.findElements(By.tagName("input")).get(1).sendKeys("Vivek");

		driver.findElement(By.xpath("(//input)[3]")).sendKeys(expEmployeeID);

		Thread.sleep(4000);

		// Click on search button
		driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();

		Thread.sleep(5000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("window.scrollBy(0," + 500 + ")");
		
		jse.executeScript("window.scrollBy(0, arguments[0]);", 500); // Interview-Recommended		
		// Cleaner
		// Avoids string manipulation bugs
		// Safer & more readable
		
		Thread.sleep(4000);
		
		// Return the no. of rows even if record found or not
		List <WebElement> rows = driver.findElements(By.xpath("//div[@role='row']"));
		
		if(rows.size()>1) {
			actEmployeeID = driver.findElement(By.xpath("((//div[@role='row'])[2]//div[@role='cell'])[2]")).getText();
		}
		Assert.assertEquals(actEmployeeID, expEmployeeID);
		System.out.println("Employee found successfully by emp ID");

	}

}
