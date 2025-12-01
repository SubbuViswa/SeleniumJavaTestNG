package com.subbu.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {

	
	private WebDriver driver;
	public ActionsUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void mouseHoverAction(By locator){
		WebElement element =driver.findElement(locator);
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
	}
	
	public void mouseHoverClickElement(By locator){
		WebElement element =driver.findElement(locator);
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
		
	}

	public void pageDown()
	{
		Actions a = new Actions(driver);
		//scroll down a page
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	public void pageUp()
	{
		Actions a = new Actions(driver);
		//scroll Up a page
		a.sendKeys(Keys.PAGE_UP).build().perform();
	}
	
	public void escapeAction(){
		Actions action=new Actions(driver);
		//Perform Escape operation on a page
		action.sendKeys(Keys.ESCAPE).build().perform();
		
		
	}
	
	public void doubleClickAction(By locator){
		WebElement element =driver.findElement(locator);
		Actions action=new Actions(driver);
		//Perform Double Click on Particular element
		action.moveToElement(element).doubleClick();
		
	}
	public void downArrow(){
		
		Actions action=new Actions(driver);
		//performs down arrow key actions
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		
	}
    
    public void upArrow(){
		
		Actions action=new Actions(driver);
		//performs Up arrow key actions
		action.sendKeys(Keys.ARROW_UP).build().perform();
		
	}
	
    public void leftArrow(){
		
		Actions action=new Actions(driver);
		//performs left arrow key actions
		action.sendKeys(Keys.ARROW_LEFT).build().perform();
		
	}
    
    public void rightArrow(){
		
		Actions action=new Actions(driver);
		//performs right arrow key actions
		action.sendKeys(Keys.ARROW_RIGHT).build().perform();
		
	}
    
    public void tabAction(){
		
		Actions action=new Actions(driver);
		//performs Tab key actions
		action.sendKeys(Keys.TAB).build().perform();
		
	}
    public void enterAction(){
		
		Actions action=new Actions(driver);
		//performs Tab key actions
		action.sendKeys(Keys.ENTER).build().perform();

	}
    
    public void clearText() {
		Actions a = new Actions(driver);
		//scroll down a page
		a.sendKeys(Keys.CLEAR).build().perform();
	}

	public void clickHold(By locator, int xaxis, int yaxis) {
		
		WebElement element =driver.findElement(locator);
		Actions action=new Actions(driver);
		action.clickAndHold(element).moveByOffset(xaxis, yaxis).release().build().perform();
	}


}
