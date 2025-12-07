package allAlerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PromptAlert {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Selenium 4

		driver.get("http://uitestingplayground.com/alerts");

		// click on prompt alert
		driver.findElement(By.xpath("//button[@id='promptButton']")).click();
		Thread.sleep(2000); // InterruptedException

		// Switch to alert
		Alert al = driver.switchTo().alert();

		// Capture the message text
		String actualAlertMessageText = al.getText();
		System.out.println(actualAlertMessageText);
		// Expected alert message text
		String expectedAlertMessageText = "Choose \"cats\" or 'dogs'.\nEnter your value:";

		// Reference for Handling double quoted string in Java :
		// https://chatgpt.com/c/6931c27d-2bd0-8322-94d2-acd7131481b8
		if (actualAlertMessageText.equals(expectedAlertMessageText)) {
			System.out.println("Alert message text verified");
		} else {
			System.out.println("Alert message text not matching");
		}

		String promptEntered = "Electra";

		al.sendKeys(promptEntered);
		al.accept();

		Thread.sleep(3000);

		Alert al2 = driver.switchTo().alert();
		String actualPromptVerificationText = al2.getText();
		System.out.println(actualPromptVerificationText);
		String expectedPromptVerificationText = "User value: "+promptEntered+"";
		Assert.assertEquals(actualPromptVerificationText, expectedPromptVerificationText);
		System.out.println("Prompted text verified");

		// Verify that the promptVerification text contains the entered text.
		if ((al2.getText()).contains(promptEntered)) {
			System.out.println("Alert verification text contains exact prompted text");
		} else {
			System.out.println("Alert text not contains prompted text");
		}
		System.out.println("Prompt Alert Verified");
		
		driver.quit();
	}
}
