package com.subbu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.subbu.utils.ElementUtil;
import com.subbu.utils.JavaScriptUtil;

public class TutorialHomePage {
	WebDriver driver;
	private ElementUtil eleUtil;
	//private JavaScriptUtil jsUtil;
	 
	private By homeLnk = By.xpath("//a[text()='Qafox.com']");
	private By my_account_lnk = By.xpath("//a[@title='My Account']");
	private By register_lnk = By.xpath("//a[@title='My Account']//following-sibling::ul//a[text()='Register']");
	
	public TutorialHomePage(WebDriver driver){
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		//jsUtil = new JavaScriptUtil(driver);
	}
	
	public boolean isTutorialNinjaHomeExists()
	{
		return eleUtil.waitForElement(60, homeLnk).isDisplayed();
		
	}
	
	public void selectRegisteroption(ExtentTest rprtMessage) {
		eleUtil.waitForElement(30, my_account_lnk);
		eleUtil.addScreenShotToReport("Screenshot - Tutorials Ninja Home Page", rprtMessage);
		eleUtil.clickElement(my_account_lnk,"Click on 'My Account' Menu Link",rprtMessage);
		eleUtil.waitForElement(30, register_lnk);
		eleUtil.clickElement(register_lnk,"Click on 'register' Menu Link",rprtMessage);		
	}
}
