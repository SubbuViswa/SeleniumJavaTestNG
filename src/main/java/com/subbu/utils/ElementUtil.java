package com.subbu.utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.subbu.factory.DriverFactory;

public class ElementUtil {
	
	private WebDriver driver;
	private JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
		jsUtil=new JavaScriptUtil(driver);
	}
	
	public WebElement waitForElement(int timeout,By locator)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebElement getElement(By locator)
	{
		WebElement element =driver.findElement(locator);
		if (DriverFactory.highlight.equalsIgnoreCase("true"))
		{
			jsUtil.highLightElement(element);
		}
		return element;
	}
	
	public List<WebElement>getElements(By locator)
	{
		return driver.findElements(locator);
		
	}
	
	public void enterData(By locator, String value,ExtentTest reportMessage)
	{
		WebElement ele= getElement(locator);
		ele.clear();
		ele.sendKeys(value);
		reportMessage.log(Status.INFO, value+" entered");
	}
	
	public void enterData(By locator, String value)
	{
		WebElement ele= getElement(locator);
		ele.clear();
		ele.sendKeys(value);
		
	}
	
	public void clickElement(By locator,String eleName, ExtentTest reportMessage)
	{
		getElement(locator).click();
		reportMessage.log(Status.INFO, eleName+" is clicked");

	}
	public void clickElement(By locator)
	{
		getElement(locator).click();
	}
	
	public String getText_WebElement(By locator)
	{
		return getElement(locator).getText();
	}
	
	public String getAttributeValue_WebElement(By locator, String attributeName)
	{
		return getElement(locator).getAttribute(attributeName);
	}
	
	public void selectValueInDropdown(By locator, String value,ExtentTest reportMessage)
	{
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		reportMessage.log(Status.INFO, value+ "selected ");
	}
	
	public void selectValueInDropdown(By locator, Integer index)
	{
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public void selectValueInDropdown_VisibleText(By locator, String value)
	{
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public void addScreenShotToReport(String message,ExtentTest reportMessage)
	{
		DriverFactory df = new DriverFactory();
		try {
			reportMessage.log(Status.INFO,message,MediaEntityBuilder.createScreenCaptureFromPath(df.getScreenshot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean displayElement(By locator,String value,ExtentTest reportMessage)
	{
		//return getElement(locator).isDisplayed();
		try {
            boolean isDisplayed = getElement(locator).isDisplayed();
            reportMessage.log(Status.PASS, value+ " is displayed ");
            return isDisplayed;
        } catch (Exception e) {
            //reportMessage.error("Element not found: " + locator);
        	reportMessage.log(Status.FAIL, value+ " is not displayed ");
            return false;
        }
    }


	public WebElement waitToClick(int timeout, By locator) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
//	public boolean isCheckboxSelected (By locator) {
//	    
//		try {
//	        WebElement checkbox = getElement(locator);
//	        return checkbox.isSelected();
//	    } 
//		catch (Exception e) {
//	        e.printStackTrace();
//	        return false;
//	    }
//	}
	
	public boolean isCheckboxSelected(WebElement checkbox) {
        return checkbox.isSelected();
    }

	public void sendKeybord_Keys(By locator,String key) throws InterruptedException
	{
		getElement(locator).click();
		Thread.sleep(2000);
		getElement(locator).sendKeys(key);
	}
	
}


