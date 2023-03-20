package org.framework.AppiumFrameworkDesign1;

import org.framework.Utill.ExtentReporterNG;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class EcommerceTC1 extends BaseTest {
	
	ExtentTest extent;
	public void preSetup()
	{
    //	Activity activity =new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		
	//driver.startActivity(activity);
//		
	//	Activity activity=new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
		//  driver.startActivity(activity);
	}
	@Test(groups= {"smoke"})
	public void FillForm_ErrorValidation() throws InterruptedException {
	//	ExtentReports extent=ExtentReporterNG.getReporterObject();
	//	extent.createTest("Initial Demo");
//		driver.findElement(By.id( "com.androidsample.generalstore:id/nameField")).sendKeys("manikanta");
			driver.hideKeyboard();
			driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
			driver.findElement(By.id("android:id/text1")).click();
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector() ).scrollIntoView(text(\"Argentina\"));"));
			driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			Thread.sleep(3000);
			String toastmessage= driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		//	Assert.assertEquals(toastmessage, "Please enter your names");
		//	extent.flush();
	}
	
	/*@Test
	public void FillForm() throws InterruptedException {
		
			driver.findElement(By.id( "com.androidsample.generalstore:id/nameField")).sendKeys("manikanta");
			driver.hideKeyboard();
			driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
			driver.findElement(By.id("android:id/text1")).click();
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector() ).scrollIntoView(text(\"Argentina\"));"));
			driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			Thread.sleep(3000);
			String toastmessage= driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
			Assert.assertEquals(toastmessage, "Please enter your name");
		}*/

}
