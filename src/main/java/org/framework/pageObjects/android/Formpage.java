package org.framework.pageObjects.android;

import org.framework.utill.AndroidActions1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Formpage extends AndroidActions1 {
	AndroidDriver driver;
	
	public Formpage(AndroidDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	
	private WebElement nameField;
	
@AndroidFindBy(xpath=("//android.widget.RadioButton[@text='Female']"))
	
	private WebElement femaleOption;

@AndroidFindBy(xpath=("//android.widget.RadioButton[@text='Male']"))

private WebElement maleOption;

     @AndroidFindBy(id="android:id/text1")
     
         private WebElement selectCountry;
     
     
     @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
     
             private WebElement submitForm;
     
     
    
     
     
     
     
     







     public void setNameField(String name) {
    	 nameField.sendKeys(name);
 		driver.hideKeyboard();

     }
     
     public void setGender(String gender) {
    	 
    	 if(gender.contains("female"))
    	 
    	 femaleOption.click();
    	 else
    		 maleOption.click();
     }
     
     
     public void setCountry(String countryName)
     {
    	 selectCountry.click();
    	 scrollToText(countryName);
    	driver.findElement(By.xpath("//android.widget.TextView[@text=\""+countryName+"\"]")).click();
    	 
     }
     
     public void submitForm() {
    	submitForm.click();
     }
     
     
     

}
