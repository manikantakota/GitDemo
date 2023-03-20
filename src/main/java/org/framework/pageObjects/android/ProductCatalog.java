package org.framework.pageObjects.android;

import java.util.List;

import org.framework.utill.AndroidActions1;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalog extends AndroidActions1{
	AndroidDriver driver;
	
	public ProductCatalog(AndroidDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath=("//android.widget.TextView[@text='ADD TO CART']"))
	
	public List<WebElement> addToCart;
	
	@AndroidFindBy(id=("com.androidsample.generalstore:id/appbar_btn_cart"))
	
	public WebElement goToCart;
	
	
	
	
	
	
	
	
	
	
	
	public void addItemsToCartByIndex(int index) {
		
		addToCart.get(index).click();
		
	}
	
	public  ProductCatalog goToCartPage() 
	{
		goToCart.click();
		
		return new ProductCatalog(driver); 
	}

}
