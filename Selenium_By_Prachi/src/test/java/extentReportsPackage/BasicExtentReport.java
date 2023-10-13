package extentReportsPackage;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicExtentReport {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	@BeforeTest
	public void configureReport() {

		htmlReporter = new ExtentSparkReporter("BasicExtentReport.html"); // Pass the name of extent report file
		// We can specify path of extent report file also.
		// Here only name is specified means, report will be stored in project directory
		// as 'BasicExtentReport'

		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// Add System Environment Details
		reports.setSystemInfo("Localhost", "LenovoPC");
		reports.setSystemInfo("OS", "Windows10");
		reports.setSystemInfo("User", "Vivek");
		reports.setSystemInfo("Browser", "Chrome");

		// Configure look and feel of report
		htmlReporter.config().setDocumentTitle("Basic Extent Report");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	@Test
	public void launchBrowser() {
		
		// Create test
		test = reports.createTest("Launch browser and open url");
		Assert.assertTrue(true); // Test Passed

	}

	@Test
	public void verifyTitle() {
		
		// Create test
		test = reports.createTest("Verify title");
		Assert.assertTrue(false); // Test Failed
	}

	@Test
	public void verifyLogo() {
		
		// Create test
		test = reports.createTest("Verify logo");
		Assert.assertTrue(true); // Test Passed
	}

	@Test
	public void verifyEmail() {
		test = reports.createTest("Verify email");
		throw new SkipException("Skipping this test case with exception..."); // Test Skipped
	}

	@Test
	public void verifyUsername() {
		
		// Create test
		test = reports.createTest("Verify Username");
		Assert.assertTrue(true); // Test Passed

	}

	@AfterMethod // This method should exec after exec of all test methods
	public void getTestResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " " + "FAILED", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " " + "PASSED", ExtentColor.GREEN));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " " + "SKIPPED", ExtentColor.YELLOW));
		}

	}

	@AfterTest // This method should execute after all test methods
	public void tearDown() {
		reports.flush();
	}
}
