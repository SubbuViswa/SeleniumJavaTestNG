package com.subbu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.subbu.utils.ElementUtil;

public class RegisterUserPage {
	WebDriver driver;
	private ElementUtil eleUtil;
	TutorialHomePage tutorialHomePage;
	
	private By firstname_loc = By.id("input-firstname");
	private By lastname_loc = By.cssSelector("#input-lastname");
	private By email_loc = By.xpath("//input[@type='email']");
	private By phone_loc = By.xpath("//input[contains(@id,'telephone')]");
	private By password_loc = By.xpath("//input[@class='form-control' and @name='password']");
	private By password_confirm_loc = By.xpath("//input[@name='confirm']");
	private By registerPageHeader = By.xpath("//h1[text()='Register Account']");
	
	public RegisterUserPage(WebDriver driver){
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		tutorialHomePage = new TutorialHomePage(driver);
	}
	
	public boolean navigateToRegisterPageFromHomePage(ExtentTest rprtMessage) {
		tutorialHomePage.isTutorialNinjaHomeExists();
		tutorialHomePage.selectRegisteroption(rprtMessage);
		String TabName = eleUtil.waitForElement(60, registerPageHeader).getText();
		eleUtil.addScreenShotToReport("Screenshot - register User Page", rprtMessage);
		if(TabName!=null)
		{
			rprtMessage.log(Status.PASS, "Register Page is Opened");
			return true;
		} else
			rprtMessage.log(Status.FAIL, "Register Page did not Open");
			return false;
	}
	
	public void fillRegistrationDetails(String firstName, String lastName, String email, String phone, String password, String passwordConfirm, String subscribe, ExtentTest rprtMessage) {
		eleUtil.enterData(firstname_loc, firstName, rprtMessage);
		eleUtil.enterData(lastname_loc, lastName, rprtMessage);
		eleUtil.enterData(email_loc, email, rprtMessage);
		eleUtil.enterData(phone_loc, phone);
		eleUtil.enterData(password_loc, password);
		eleUtil.enterData(password_confirm_loc, passwordConfirm, rprtMessage);
		eleUtil.clickElement(By.xpath("//label[@class='radio-inline' and text()='"+subscribe+"']"));
	}
}
