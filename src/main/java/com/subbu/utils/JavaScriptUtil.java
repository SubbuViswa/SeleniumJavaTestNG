package com.subbu.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	private WebDriver driver;	
	public JavaScriptUtil(WebDriver driver)
	{
		this.driver=driver;
	}

	public void highLightElement(WebElement element)
	{
		String bgColor=element.getCssValue("backgroundColor");
		for(int i=0;i<15;i++)
		{
			changeColor("rgb(0,200,0)",element);
			changeColor(bgColor,element);
		}
		
	}
	
	public void changeColor(String color,WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
		try
		{
			Thread.sleep(10);
		}
		catch(InterruptedException  e)
				{
			
	}
	}
	

	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		// Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void jscriptElementClick(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public void pageRefresh() 
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);       
		js.executeScript("window.location.reload();");

	}
	
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);					
	    js.executeScript("arguments[0].scrollIntoView({behavior:'smooth',block:'center', inline: 'nearest'});",element);
	}

	
	public void scrollToPageBottom()
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);					
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}	
	
	public void scrollToPageUP()
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);					
	    js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
	}
	
	public void clickElement(WebElement element) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);	
		js.executeScript("arguments[0].click();", element);
		
	}
	public void scrollUpOrDown(WebElement element,int startPoint,int endPoint) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy("+startPoint+","+endPoint+")", "");
	}
	public void clearInputArea(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].value ='';", element);

	}

	public void scrollWithinTable(WebElement element) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollTop=arguments[0].scrollHeight;", element);
		
	}
	
	public void scrollHorizontal(WebElement element)
	{
		JavascriptExecutor js= ((JavascriptExecutor)driver);					
	    js.executeScript("document.querySelector('table th:last-child').scrollIntoView();");
	}	
	}

