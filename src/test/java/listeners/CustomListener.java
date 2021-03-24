package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener implements ITestListener{

	public void onFinish(ITestContext context) {

	}

	public void onStart(ITestContext context) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output","false");
		Reporter.log("<a href=\"C:/Users/pooja-devgan/Pictures/error.jpg\" target=\"_blank\">Screenshot captured</a>");
		Reporter.log("<br>");
		Reporter.log("<a href=\"C:/Users/pooja-devgan/Pictures/error.jpg\" target=\"_blank\"><img height=200 width=200 src=\"C:/Users/pooja-devgan/Pictures/error.jpg\"></a>");


	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

}
