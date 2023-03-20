package org.framework.Utill;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.framework.AppiumFrameworkDesign1.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ExtentReportsDemo {
	public AndroidDriver driver;
	AppiumDriverLocalService service;
      ExtentReports extent;
      ExtentTest test;
	//D:\\Tosca\\Apium Tools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe
	@BeforeTest
	public void config()
	{
		//ExtentReports //ExtentSparkReports
		String path=System.getProperty("user.dir")	+ "\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Resuts");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "manikanta");
		
		
	} 
	@Test
	public void initialDemo() throws InterruptedException, MalformedURLException {
	ExtentTest test=	extent.createTest("Initial Demo");
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HMSPL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				  .withIPAddress("127.0.0.1").usingPort(4723).build();
		  
		  service.start();
		  UiAutomator2Options options= new UiAutomator2Options();
		 
		  options.setDeviceName("Pixel XL API 30");
		  
		  options.setChromedriverExecutable("D:\\Tosca\\Apium Tools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		  options.setApp("C:\\Users\\HMSPL\\Downloads\\General-Store.apk");
		
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
	
				 
				 

		 //    	driver.findElement(By.id( "com.androidsample.generalstore:id/nameField")).sendKeys("manikanta");
			driver.hideKeyboard();
			driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
			driver.findElement(By.id("android:id/text1")).click();
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector() ).scrollIntoView(text(\"Argentina\"));"));
			driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			Thread.sleep(3000);
			String toastmessage= driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		//	Assert.assertEquals(toastmessage, "Please enter your name");
			//driver.quit();
		test.fail("result do not match");
		
		extent.flush();
		
	}

}
