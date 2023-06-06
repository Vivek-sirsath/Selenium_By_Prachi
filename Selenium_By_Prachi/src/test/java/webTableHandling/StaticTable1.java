package webTableHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 There are two types of HTML tables published on the web-

1) Static tables: Data is static i.e. Number of rows and columns are fixed.
2) Dynamic tables: Data is dynamic i.e. Number of rows and columns are NOT fixed. 
 */

public class StaticTable1 {

	public static void main(String[] args) {
		
		// setting the property of chrome browser and passing the chromedriver path
				System.setProperty("webdriver.chrome.driver","E:\\EDUCATIONAL\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get("https://testautomationpractice.blogspot.com/");
				
				// Let the control to find the WebTable
//				List <WebElement> oneElement = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[2]/td[1]"));
				// This will print element of 2nd Row - 1st Column // Learn Selenium
				
//				for(WebElement e: oneElement) {
//					System.out.println(e.getText());
//				}
				
				// To print all elements in first column
				List <WebElement> firstColumnElements = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[1]"));
				for(WebElement e2 : firstColumnElements) {
					System.out.println(e2.getText());
				}
				System.out.println("-------------------------------------------------");
				
				// To print all elements in second column
				List <WebElement> secondColumnElements = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[2]"));
				for(WebElement e2 : secondColumnElements) {
					System.out.println(e2.getText());
				}
				System.out.println("--------------------------------------------------");
				
				// To print all elements in third column
				List <WebElement> thirdColumnElements = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[3]"));
				for(WebElement e2 : thirdColumnElements) {
					System.out.println(e2.getText());
				}
				
				System.out.println("---------------------------------------------------");
				
				// To print all elements in fourth column
				List <WebElement> fourthColumnElements = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td[4]"));
				for(WebElement e2 : fourthColumnElements) {
					System.out.println(e2.getText());
				}
	
	}

}
