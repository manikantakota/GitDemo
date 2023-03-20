package org.framework.utill;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions1  {
	
	  AndroidDriver driver;
		 
		 public  AndroidActions1(AndroidDriver driver) {
			 this.driver=driver;
			 
			 
		 }

		public void longPressAction(WebElement ele) {
			
			((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
					ImmutableMap.of("elementId",  ((RemoteWebElement)ele).getId(), "duration", 2000));
		}
		
		public void scrollToText(String text) {
			driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector() ).scrollIntoView(text(\""+text+"\"));"));
		}
		
		
		
		public void scrollToEndAction() {
			boolean canScrollMore;
			do {
			 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100,  "width", 200, "height", 200,
				    "direction", "down", 
			      "percent", 3.0
				));
			}while(canScrollMore);
		}
		
		
		public void swipeAction(WebElement ele, String direction ) {
			
			((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
					"elementId", ((RemoteWebElement)ele).getId(),
					
				 
				    "direction", direction,
				    "percent", 0.75
				));
		}
		
		
		
		public void dragAndDropActions(WebElement source, int Xcordinate, int Ycordinate) {
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement) source).getId(),
				    "endX", Xcordinate,
				    "endY", Ycordinate
				));
		}
		
		
		public Double getFormattedAmount(String amount)
		{
			Double price= Double.parseDouble(amount.substring(1));	
			return price;
		}
		
		
		public void getScreenShot(String testCaseName, AppiumDriver driver) {
			
			File source=driver.getScreenshotAs(OutputType.FILE);
			String destinationFile=System.getProperty("user.dir")	+ "\\reports"+testCaseName+".png";
			//FileUtils.copyFile(source, destinationFile);
			
			
		}
		
		
		
		
		
		
		

}
