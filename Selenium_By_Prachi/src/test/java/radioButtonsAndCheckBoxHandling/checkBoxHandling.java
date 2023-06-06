package radioButtonsAndCheckBoxHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkBoxHandling {

	public static void main(String[] args) throws Exception {
		
		// Launch the chrome browser instance
				System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("http://uitestpractice.com/Students/Form");
				
				
				boolean c1 = driver.findElement(By.xpath("//label[normalize-space()='Dancing']")).isDisplayed();
				System.out.println("Is Dancing Displayed?:- " + c1);
				boolean c2 = driver.findElement(By.xpath("//label[normalize-space()='Reading']")).isDisplayed();
				System.out.println("Is Reading Displayed?:- " + c2);
				boolean c3 = driver.findElement(By.xpath("//label[normalize-space()='Cricket']")).isDisplayed();
				System.out.println("Is Cricket Displayed?:- " + c3);
				
				
				
				boolean a1 = driver.findElement(By.xpath("//label[normalize-space()='Dancing']")).isEnabled();
				System.out.println("Is Dancing Enabled?:- " + a1);
				boolean a2 = driver.findElement(By.xpath("//label[normalize-space()='Reading']")).isEnabled();
				System.out.println("Is Reading Enabled?:- " + a2);
				boolean a3 = driver.findElement(By.xpath("//label[normalize-space()='Cricket']")).isEnabled();
				System.out.println("Is Cricket Enabled?:- " + a3);
				
				
				
				boolean b1 = driver.findElement(By.xpath("//label[normalize-space()='Dancing']")).isSelected();
				System.out.println("Is Dancing Selected?:- " + b1);
				boolean b2 = driver.findElement(By.xpath("//label[normalize-space()='Reading']")).isSelected();
				System.out.println("Is Reading Selected?:- " + b2);
				boolean b3 = driver.findElement(By.xpath("//label[normalize-space()='Cricket']")).isSelected();
				System.out.println("Is Cricket Selected?:- " + b3);
				
				// Find all hobbies and store in a variable using List<WebElement> Interface
				List <WebElement> hobbies =driver.findElements(By.xpath("//label[@class='checkbox-inline']"));
				System.out.println("Hobbies are:- " + hobbies.size());
				
				
				// Store expected hobby in Sting variable
				String ExpResult1 = "Reading";
				String ExpResult2 = "Dancing";
				String ExpResult3 = "Cricket";
				
				// Iterate using for loop to click that variable
				for(int i=0;i<hobbies.size();i++) {
					if(hobbies.get(i).getText().equalsIgnoreCase(ExpResult1)) {
						hobbies.get(i).click();
						System.out.println("Reading Checkbox Verified");
					}
					Thread.sleep(3000);
					if(hobbies.get(i).getText().equalsIgnoreCase(ExpResult2)) {
						hobbies.get(i).click();
						System.out.println("Dancing Checkbox Verified");
						Thread.sleep(3000);
					}
					if(hobbies.get(i).getText().equalsIgnoreCase(ExpResult3)) {
						hobbies.get(i).click();
						System.out.println("Cricket Checkbox Verified");
						Thread.sleep(3000);
					}
				}
				
				
	}

}
