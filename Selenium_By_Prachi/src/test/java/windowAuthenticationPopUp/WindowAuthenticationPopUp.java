
/*
 * How to handle window authentication pop-up?
 * We can not locate this using x path because it is not the web element
 * It is the windows pop-up.
 * 
 * This type of pop-up shows different GUI on different browsers
 * such as Chrome, Firefox
 * 
 * */

package windowAuthenticationPopUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowAuthenticationPopUp {

	public static void main(String[] args) {

		// Launch chrome browser
		System.setProperty("webdriver.chrome.driver", "E:\\Educational\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// URL - https://the-internet.herokuapp.com/basic_auth
		// admin:admin = username:password
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		// Launch firefox browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver ṁṇ = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

	}

}
