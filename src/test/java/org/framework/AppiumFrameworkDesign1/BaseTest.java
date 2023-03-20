package org.framework.AppiumFrameworkDesign1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest   {
	 public AndroidDriver driver;
	 
	 AppiumDriverLocalService service;
	
	@BeforeClass(alwaysRun=true)
	 public void ConfigureAppium() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\org\\framework\\pageObjects\\resources\\data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		
	//String port=prop.getProperty("port");
	
	String androidDeviceName=prop.getProperty("AndroidDeviceName");
	
	
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HMSPL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				  .withIPAddress(ipAddress).usingPort(4723).build();
		  
		  service.start();
		  UiAutomator2Options options= new UiAutomator2Options();
		 
		  options.setDeviceName(androidDeviceName);
		  
		  options.setChromedriverExecutable("D:\\Tosca\\Apium Tools\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		  options.setApp("C:\\Users\\HMSPL\\Downloads\\General-Store.apk");
		
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
	}
	public String getScreenShotPath(String testCaseName, AppiumDriver driver) throws IOException {
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")	+ "\\reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
	}
	
	
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		 driver.quit();
		  service.stop();
	}

}
