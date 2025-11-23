
// Reference:- https://rahulshettyacademy.com/blog/index.php/2023/11/21/explicit-wait-in-selenium/

package seleniumWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait2 {

	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://uitestingplayground.com/ajax");

		driver.findElement(By.xpath("//button[@id='ajaxButton']")).click();

//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15)); //success
//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(14)); //fail

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(16)); // success
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='bg-success']")));

		String ajax_message = driver.findElement(By.xpath("//p[@class='bg-success']")).getText();

		System.out.println(ajax_message);

	}

}