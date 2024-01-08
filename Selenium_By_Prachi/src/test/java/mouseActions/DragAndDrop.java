package mouseActions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws Exception {
		
		// Launch the chrome browser instance
				System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   // Selenium 3
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Selenium 4
				driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
				
				WebElement source1 = driver.findElement(By.id("box1")); // Oslo
				WebElement target1 = driver.findElement(By.id("box101")); // Norway
				
				WebElement source2 = driver.findElement(By.id("box2")); // Stockholm
				WebElement target2 = driver.findElement(By.id("box102")); // Sweden
				
				WebElement source3 = driver.findElement(By.id("box3")); // Washigton
				WebElement target3 = driver.findElement(By.id("box103")); // United States
				
				WebElement source4 = driver.findElement(By.id("box4")); // Copenhagen
				WebElement target4 = driver.findElement(By.id("box104")); // Denmark
				
				WebElement source5 = driver.findElement(By.id("box5")); // Seoul
				WebElement target5 = driver.findElement(By.id("box105")); // South Korea
				
				WebElement source6 = driver.findElement(By.id("box6")); // Rome
				WebElement target6 = driver.findElement(By.id("box106")); // Italy
				
				WebElement source7 = driver.findElement(By.id("box7")); // Madrid
				WebElement target7 = driver.findElement(By.id("box107")); // Spain
				
				// Implement Actions Class
				Actions act = new Actions(driver);
				
				// Drag and Drop Source Elements to Target Elements
				Thread.sleep(2000);
				act.dragAndDrop(source1, target1).perform();
				Thread.sleep(2000);
				act.dragAndDrop(source2, target2).perform();
				Thread.sleep(2000);
				act.dragAndDrop(source3, target3).perform();
				Thread.sleep(2000);
				act.dragAndDrop(source4, target4).perform();
				Thread.sleep(2000);
				act.dragAndDrop(source5, target5).perform();
				Thread.sleep(2000);
				act.dragAndDrop(source6, target6).perform();
				Thread.sleep(2000);
				act.dragAndDrop(source7, target7).perform();
				
				System.out.println("Drag and Drop Verified");
				
				driver.navigate().refresh();
				Thread.sleep(2000);
				driver.close();
				
				
	}

}
