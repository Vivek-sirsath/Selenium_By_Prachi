package dataProviderAnnotation;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviterWithExcel {

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
	@DataProvider(name = "searchDataProviderMethod")
	public Object[][] searchDataProvider() {
		

		String  fileName = "C:\\Users\\Admin\\Desktop\\searchDataFile.xlsx";
		// Create 2D array and Store data in it
		Object[][] searchData = getExcelData(fileName, "Sheet1");

		return searchData;

	}

	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] data = null;

		// Open the file in Read Mode
		try {
			FileInputStream inputStreamObj = new FileInputStream(fileName);
			XSSFWorkbook workBook = new XSSFWorkbook(inputStreamObj);
			XSSFSheet sheetObj = workBook.getSheet(sheetName);

			// Get total no of rows
			int ttlRows = sheetObj.getLastRowNum() + 1;

			// Get total no of cells
			int ttlCells = sheetObj.getRow(0).getLastCellNum(); // We can select any row 2,1,3 But selected 0-th row
																// (1st)
			
			// Initialize Array
			data = new String[ttlRows-1][ttlCells];

			for (int currentRow = 1; currentRow < ttlRows; currentRow++) {   // our data staring from 1st index row
				                                                             // Otherwise will take "Keword" name

				for (int currentCell = 0; currentCell < ttlCells; currentCell++) {
					
					data[currentRow-1][currentCell] = sheetObj.getRow(currentRow).getCell(currentCell).getStringCellValue();

				}
			}
			workBook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	@AfterMethod
	public void qtearDown() {
		driver.quit();
	}

}
