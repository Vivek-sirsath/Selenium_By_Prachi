
/*
 * navigate().to()  vs  get() 
 * 
 * driver.get() ---> Accepts URL only in String format
 * driver.navigate().to() ---> Accepts URL only in String format & 'URL Object' format
 * */

package navigateToVsGetMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateTo_vs_Get {

	public static void main(String[] args) throws MalformedURLException {
		
		WebDriver driver = new ChromeDriver();
		
//		driver.get("https://demo.nopcommerce.com/");
		
		// navigate().to("String URL")
		driver.navigate().to("https://demo.nopcommerce.com/");
		
		// This method internally calls get() method
		// But, navigate().to() method can accept 'URL Object' also
		
//		URL urlObject = new URL("https://demo.nopcommerce.com/");
//		driver.navigate().to(urlObject);

	}

}
