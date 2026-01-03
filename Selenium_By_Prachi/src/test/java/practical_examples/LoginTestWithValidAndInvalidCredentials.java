package practical_examples;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTestWithValidAndInvalidCredentials {

	public String baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(baseURL);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@Test(priority = 1, enabled = true)
	public void loginWithInvalidCredentials() {
		// find username and enter username "Admin"
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

		// find password and enter password admin123
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123"); //  Invalid Password

		// login button click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		// Verify unsuccessful login by checking the message texthecking the page title
		WebElement msg = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));
		String actualMsgText = msg.getText();
		String expectedMsgText = "Invalid credentials";
		Assert.assertTrue(actualMsgText.contains(expectedMsgText));
		System.out.println("Message text verified Ok, Login with Invalid Credential test passed");

	}

	@Test(priority = 2, enabled = true)
	public void loginWithValidCredentials() throws InterruptedException {
		// find username and enter username "Admin"
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");

		// find password and enter password admin123
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		// login button click
		driver.findElement(By.xpath("//button[@type='submit']")).submit();

		// Verify login successful checking the page title
		String pageTitle = driver.getTitle();
		if (pageTitle.equalsIgnoreCase("OrangeHRM")) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Login failed..!");
		}
		Thread.sleep(5000);
		System.out.println("Page title verified Ok, Login with Valid Credential test passed");
		logout();

	}

	public void logout() throws InterruptedException {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		System.out.println("User dropdown icon clicked");
		Thread.sleep(6000);

//		FIRST WAY
//		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();

//		SECOND WAY
		List<WebElement> menuList = driver.findElements(By.xpath("//a[@class='oxd-userdropdown-link']"));
		for (int i = 0; i < menuList.size(); i++) {
			System.out.println(i + ":" + menuList.get(i).getText());
		}
		menuList.get(3).click();

		String pageTitle = driver.getTitle();
		if (pageTitle.equalsIgnoreCase("OrangeHRM")) {
			System.out.println("Logout verified");
		} else {
			System.out.println("Logout failed..!");
		}

		System.out.println("Logout option clicked");
		Thread.sleep(5000);
		driver.navigate().refresh();

	}

	@AfterTest(enabled = false)
	public void tearDown() throws InterruptedException {

		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
