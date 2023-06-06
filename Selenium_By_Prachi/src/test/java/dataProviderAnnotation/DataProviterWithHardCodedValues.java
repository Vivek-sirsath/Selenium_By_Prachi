package dataProviderAnnotation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviterWithHardCodedValues {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		// Launch Chrome Browser		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		// Maximize the browser
		driver.manage().window().maximize();
		
		// Open URL
		driver.get("http://www.google.com");
		
	}
	
	// Locate searchBox and enter Data
	@Test(dataProvider = "searchDataProviderMethod")
	public void clickAndEnterInSearchBox(String keyword) {
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(keyword);
		searchBox.sendKeys(Keys.ENTER);
		
	}
	// Create searcDataProvider Object Array
	@DataProvider(name = "searchDataProviderMethod" )
	public Object[][] searchDataProvider(){
		
		// Create 2D array and Store data in it
		Object[][] searchData = new Object[2][1];
		searchData[0][0] = "Manual Testing";    // Row-1, Column-1  // Hard Coded data
		searchData[1][0] = "Automation Testing";   // Row-2, Column-1  // Hard Coded data
				
		return searchData;
		
	}
	
	@AfterMethod
	public void qtearDown() {
		driver.quit();
	}

}
