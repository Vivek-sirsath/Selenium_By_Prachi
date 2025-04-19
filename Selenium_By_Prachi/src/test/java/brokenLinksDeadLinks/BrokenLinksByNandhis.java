package brokenLinksDeadLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksByNandhis {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   // Selenium 3
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // Selenium 4
		driver.get("http://www.deadlinkcity.com/");

//		STEP 1 :- Find the links which has anchor tag a/img
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("No. of links:- " + allLinks.size());

//		STEP 2 :- Eliminate the duplicate URLs
		Set<String> s = new HashSet<>();

		for (WebElement e : allLinks) {
			String link = e.getAttribute("href");

			if (link != null && !(link.isEmpty())) {
				s.add(link);
			}
		}
		System.out.println(s.size());

//		STEP 3 :- Verify the link is opening or not
		int noOfBrokenLinks = 0;

		for (String url : s) {
		    if (url.startsWith("http://") || url.startsWith("https://")) {
		        try {
		            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		            connection.setConnectTimeout(5000);
		            connection.connect();
		            int resCode = connection.getResponseCode();

		            if (resCode >= 400) {
		                noOfBrokenLinks++;
		                System.out.println("Broken Link :- " + url + " --> " + resCode);
		            }
		        } catch (MalformedURLException e) {
		            System.out.println("Skipping malformed URL: " + url);
		            noOfBrokenLinks++;
		        } catch (IOException e) {
		            System.out.println("IOException for URL: " + url);
		            noOfBrokenLinks++;
		        }
		    } else {
		        // Skipping non-http(s) URLs (like mailto:, javascript:, etc.)
		        System.out.println("Skipping non-HTTP URL: " + url);
		    }
		}

		System.out.println("No of broken links :- " + noOfBrokenLinks);
		
		driver.close();
	}

}
