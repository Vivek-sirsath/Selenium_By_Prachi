package CountAndWriteHyperlinks;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hyperlinks {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   // Selenium 3
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Selenium 4
		driver.get("https://www.calculator.net/");
		
		List <WebElement> allHyperliks = driver.findElements(By.tagName("a"));
		System.out.println("No. of Web Elements:-" + allHyperliks.size());
		
		for(WebElement e : allHyperliks) {
			System.out.println(e.getText());
						
		}
		String expectedLinktext = "Loan Calculator";
		for(int i=0; i < allHyperliks.size(); i++) {
			if(allHyperliks.get(i).getText().equalsIgnoreCase(expectedLinktext)) {
				System.out.println("-------------Expected hyperlink clicked-------------");
				allHyperliks.get(i).click();
				System.out.println("Loan Calculator Clicked");
			}
		}
		
		driver.close();
	}
	

}
