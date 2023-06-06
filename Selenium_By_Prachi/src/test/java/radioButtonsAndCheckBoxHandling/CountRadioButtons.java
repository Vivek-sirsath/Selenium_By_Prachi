package radioButtonsAndCheckBoxHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountRadioButtons {

	public static void main(String[] args) throws Exception {
		
		// Launch the chrome browser instance
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.udyamregistration.gov.in/Udyam_Login.aspx");
		
		List <WebElement> allRadios = driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("No. of radio buttons:- " + allRadios.size());
		
		boolean a = driver.findElement(By.xpath("//label[normalize-space()='OTP on Mobile as filled in application']")).isSelected();
		System.out.println(a);
		boolean b = driver.findElement(By.xpath("//label[normalize-space()='OTP on Email as filled in application']")).isEnabled();
		System.out.println(b);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[normalize-space()='OTP on Email as filled in application']")).click();
		System.out.println("2nd Option clicked");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[normalize-space()='OTP on Mobile as filled in application']")).click();
		System.out.println("1st Option clicked");
		
		
		
		
	}

}
