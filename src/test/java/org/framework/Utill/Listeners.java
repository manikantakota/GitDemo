package org.framework.Utill;

import java.io.IOException;

import org.framework.AppiumFrameworkDesign1.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	AppiumDriver driver;
	
	ExtentReports extent=ExtentReporterNG.getReporterObject();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		 test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.PASS, "Test Pased");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.fail(result.getThrowable());
		
		
		test.fail(result.getThrowable());
		try {
			driver=(AppiumDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver), getScreenShotPath(result.getMethod().getMethodName(),driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
