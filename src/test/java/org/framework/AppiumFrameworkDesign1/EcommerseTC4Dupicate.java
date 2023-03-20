package org.framework.AppiumFrameworkDesign1;

import org.framework.pageObjects.android.CartPage;
import org.framework.pageObjects.android.Formpage;
import org.framework.pageObjects.android.ProductCatalog;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EcommerseTC4Dupicate extends BaseTest {
	
	@Test()
	public void FillForm() throws InterruptedException {
		
		Formpage form =new Formpage(driver);
		
		form.setNameField("manikanta");
		form.setCountry("Argentina");
		form.setGender("female");
		form.submitForm();
		
		ProductCatalog productCatalogue =new ProductCatalog(driver);
		productCatalogue.addItemsToCartByIndex(0);
		productCatalogue.addItemsToCartByIndex(0);
		
		ProductCatalog cart= productCatalogue.goToCartPage();
		
		CartPage CartPrice= new CartPage(driver);
		CartPrice.productPrice();
		
		//	CartPage CartPrice= new CartPage(driver);
		//	CartPrice.productPrice();
			
			
			
			

			
			
	/*	//	driver.findElement(By.id("android:id/text1")).click();
		//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector() ).scrollIntoView(text(\"Argentina\"));"));
		//	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
			driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			Thread.sleep(3000);
		//	String toastmessage= driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		//	Assert.assertEquals(toastmessage, "Please enter your name");
			
			driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
			driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//	driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART'][1]")).click();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
			
		     System.out.println("products added");
		     
		     //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		    // wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		     System.out.println("Cart page is seuccess");
			List<WebElement> productPrices=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
			 System.out.println("Product price list" + productPrices);
			
			int count=productPrices.size();
			 System.out.println("Product price list" + count);
			
			double totalSum=0;
			for(int i=0; i<count; i++)
			{
				String amountString= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
				System.out.println("amount is" + amountString);
				
				Double price= Double.parseDouble(amountString.substring(1));
				System.out.println("amount is" + price);
				
			 totalSum=totalSum+price;
				 System.out.println(totalSum);
			}
			

				 //  String lastPageProduct=  driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		//   Assert.assertEquals(lastPageProduct, "Air Jordan 9 Retro");
		   
		  String totalAmount= driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		     
		/*  Double displayFormattedSum=getFormattedAmount(totalAmount);
		  Assert.assertEquals(totalSum, displayFormattedSum);
		  
			WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		  
			longPressAction(ele);
			driver.findElement(By.id("android:id/button1")).click();
	         driver.findElement(By.className("android.widget.CheckBox")).click();
	         driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	         
	         Thread.sleep(10000);
	         Thread.sleep(10000);
	         Set<String> contexts= driver.getContextHandles();
	         for(String contextNames:contexts)
	         {
	        	 System.out.println(contextNames);
	         }
	         Thread.sleep(10000);
	       driver.context("WEBVIEW_com.androidsample.generalstore");
	     //  driver.findElement(By.name("q")).sendKeys("Rahul shetty accademy");
	    // //  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    //  driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    //  driver.context("NATIVE-APP");*/
		
		
		
			
		
	
	}
	
	
	//@DataProvider
	
    // public Object[][]  getData()
	//{
	//	return new Object[][] {{"manikanta","femaile","Argentina"}};
	//}
		
		

}
