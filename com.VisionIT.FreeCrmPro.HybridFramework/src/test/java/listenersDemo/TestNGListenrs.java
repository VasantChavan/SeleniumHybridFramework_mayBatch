package listenersDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListenrs implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test case started and test case details are : "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case success and test case details are : "+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test case falied and test case details are : "+result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped and details are  : "+result.getName());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
