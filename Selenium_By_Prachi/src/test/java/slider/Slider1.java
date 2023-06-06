package slider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Slider1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement slider =driver.findElement(By.xpath("//span[@tabindex='0']"));
	
		for(int i=0; i<=50; i++) {        // 50 is the times that, How many times we want to slide the slider e.g. 40,70,95 %
		slider.sendKeys(Keys.ARROW_RIGHT);
		System.out.println("slider action performed");
	    }

		

	}

}
