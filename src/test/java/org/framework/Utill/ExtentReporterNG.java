package org.framework.Utill;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
    static ExtentReports extent;
	//D:\\Tosca\\Apium Tools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe
	
	public  static  ExtentReports getReporterObject()
	{
		//ExtentReports //ExtentSparkReports
		//ExtentReports //ExtentSparkReports
				String path=System.getProperty("user.dir")	+ "\\reports\\index.html";
				ExtentSparkReporter reporter=new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Resuts");
				reporter.config().setDocumentTitle("Test Results");
				
				 extent=new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "manikanta");
	//extent.createTest("Initial Demo");	
				return extent;
	
	}

}
