package brokenLinksDeadLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {

		// Launch chrome browser and URL
		System.setProperty("webdriver.chrome.driver", "E:\\EDUCATIONAL\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   // Selenium 3
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Selenium 4
		driver.get("http://www.deadlinkcity.com/");

		// Find all hyperlinks
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of links: " + linkList.size());

		int resCode = 200; // Link having 2xx response code is valid link
		int brokenLinkCount = 0;

		for (WebElement element : linkList) {

			String url = element.getAttribute("href");

			try {

				URL urlLink = new URL(url);

				HttpURLConnection connectionObj = (HttpURLConnection) urlLink.openConnection(); // Type casting
				/*
				 * ABOVE LINE EXCEPTION IS COMMING --> 
				 * Exception in thread "main" java.lang.ClassCastException: class
				 * sun.net.www.protocol.mailto.MailToURLConnection cannot be cast to class
				 * java.net.HttpURLConnection (sun.net.www.protocol.mailto.MailToURLConnection
				 * and java.net.HttpURLConnection are in module java.base of loader 'bootstrap')
				 * at brokenLinksDeadLinks.BrokenLinks.main(BrokenLinks.java:41)
				 */

				connectionObj.setRequestMethod("HEAD");
				connectionObj.connect();

				resCode = connectionObj.getResponseCode();

				if (resCode >= 400) {
					System.out.println(url + " - Broken Link.");
					brokenLinkCount++;
				}

			} catch (MalformedURLException e) {

			} catch (IOException e) {

			}
		}
		System.out.println("Total broken links: " + brokenLinkCount);
	}

}
