package ExtentReportsUsingITestListenerInterface;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport() {
		
		htmlReporter = new ExtentSparkReporter("Extent Report Using ITestListener");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		// Add System/Environment information to reports
		
		reports.setSystemInfo("Localhost", "LenovoPC");
		reports.setSystemInfo("OS", "Windows10");
		reports.setSystemInfo("User", "Vivek");
		reports.setSystemInfo("Browser", "Chrome");
		
		// Configure look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report");
		htmlReporter.config().setReportName("My first extent report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
	}
	
	public void onStart(ITestContext result) {
		configureReport();   // this method invoke at start of execution of test cases
		System.out.println("On Start method invoked");
	}
	
	public void onFinish(ITestContext result) {
		System.out.println("On Finish method invoked");
		reports.flush();
	}
	
	// When test case get failed this method is called
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of the test method failed:- " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " " + "FAILED", ExtentColor.RED));
		test.fail(result.getThrowable());
	}
	
	// When test case get skipped this method is called
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of the test method skipped:- " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " " + "SKIPPED", ExtentColor.YELLOW));
	}
	
	// When test case get started this method is called
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the test method started:- " + result.getName());
	}
	
	// When test case get passed this method is called
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the test method successfully executed:- " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " " + "PASSED", ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinsuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
}
