package org.framework.pageObjects.android;

import java.util.List;

import org.framework.utill.AndroidActions1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions1 {
	
	 AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	
	private List<WebElement> productPrice;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  void productPrice()
	{
		int count= productPrice.size();
		double sum=0;
		for(int i=0; i<count; i++)
		{
			String productSum=productPrice.get(i).getText();
			Double price= Double.parseDouble(productSum.substring(1));
			
			sum=sum+price;
			System.out.println("sum");
			
		}
		
		
	}


}



