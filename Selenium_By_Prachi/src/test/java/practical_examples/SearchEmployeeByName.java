package practical_examples;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchEmployeeByName {
	

		public String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		public WebDriver driver;

		@BeforeTest
		public void setup() {

			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get(baseURL);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}

		@AfterTest(enabled = true)
		public void tearDown() throws InterruptedException {

			Thread.sleep(2000);
			driver.close();
			driver.quit();
		}

		@Test
		public void searchEmployee() throws InterruptedException {
			
//			Find username and enter username "Admin"
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");

			//		Find password and enter password admin123
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

			//		Login button click
			driver.findElement(By.xpath("//button[@type='submit']")).submit();

			//		Click on PIM menu
			driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

			Thread.sleep(3000);

			//		Click on AddEmployee option
			driver.findElement(By.linkText("Add Employee")).click();

			Thread.sleep(3000);

			//		Enter First Name
			driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Vivek");

			//		Enter Last Name
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Sirsath");

			//		Click on Save button
			driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

			//		Click on PIM menu
			driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

			Thread.sleep(3000);

			//		Click on EmployeeList option
			driver.findElement(By.xpath("//a[normalize-space()='Employee List']")).click();

			//		Enter First Name
			//driver.findElements(By.tagName("input")).get(1).sendKeys("Vivek");
			
			driver.findElement(By.xpath("(//input)[2]")).sendKeys("Vivek");
			
			Thread.sleep(4000);
			
			//		Click on search button 
			driver.findElement(By.xpath("//button[contains(.,'Search')]")).click();

			Thread.sleep(5000);
			
			// 		Locate the 'Records found' element.
			List <WebElement> elements = driver.findElements(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]"));
			
			String expText = "Records Found";
			String actText = elements.get(0).getText();
			Assert.assertTrue(actText.contains(expText));

		}

}
