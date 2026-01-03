package practical_examples;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AddEmployeeTest {

	public String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(baseURL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@AfterTest(enabled = false)
	public void tearDown() throws InterruptedException {

		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	@Test
	public void addEmployee() throws InterruptedException {
		//		Find username and enter username "Admin"
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
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Abcd");

		//		Enter Last Name
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Xyzd");

		//		Click on Save button
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

		Thread.sleep(5000);
		
		System.out.println("Sleep applied");

//		String actualEmpNameTxt = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 --strong']")).getText();
//		System.out.println(actualEmpNameTxt);

//		if(actualEmpNameTxt.contains("Abcd Xyzd")) 
//		{
//			System.out.println("New Employee Added");
//		}else {
//			System.out.println("Failed to Add Employee");
//		}
	}
}
