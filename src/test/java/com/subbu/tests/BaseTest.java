package com.subbu.tests;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.subbu.factory.DriverFactory;
import com.subbu.factory.ReportFactory;

import com.subbu.pages.RegisterUserPage;
import com.subbu.utils.ActionsUtils;
import com.subbu.utils.DateTimeUtils;
import com.subbu.utils.ExcelUtil;
import com.subbu.utils.FileUtil;
import com.subbu.utils.IDGeneratorUtil;

import com.subbu.pages.TutorialHomePage;


public class BaseTest {

	DriverFactory df;
	WebDriver driver;
	Properties prop;
	ActionsUtils au;
	IDGeneratorUtil idGen;
	FileUtil fu;
	ExcelUtil excel;

	TutorialHomePage tutorialHomePage;
	RegisterUserPage registerUserPage;

	private static final String OUTPUT_FOLDER="./Reports/";
	private static final String FILE_NAME="TestAutomation__"+ DateTimeUtils.getCurrentDateTime() +".html";
	
	public static ExtentReports report=new ExtentReports(); 
	public static ExtentHtmlReporter extent;
	public static ExtentTest reportMessage;
	
		
	@BeforeSuite(alwaysRun=true)
	public void setupSuite() throws IOException
	{
		
		extent = new  ExtentHtmlReporter(new File(OUTPUT_FOLDER+FILE_NAME));
		extent.config().setDocumentTitle("Test Execution Results");
		extent.config().setReportName("Automation Test Results");
		extent.config().setAutoCreateRelativePathMedia(true);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Author", "Innova QA");
		report.attachReporter(extent);
	}		
	
	@BeforeMethod(alwaysRun=true)
	public void setUp()
	{
		//Initialize the driver object
		df= new DriverFactory();
		prop=df.initProperties();
		driver=df.initDriver(prop);
		
		// Creating the object of Page classes
		au=new ActionsUtils(driver);
		idGen=new IDGeneratorUtil();
		fu=new FileUtil();
	    excel=new ExcelUtil();

	    
	    tutorialHomePage = new TutorialHomePage(driver);
	    registerUserPage = new RegisterUserPage(driver);
		}

	
	@AfterMethod(alwaysRun=true)
	public void updateResults(ITestResult result) {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			try {
				ReportFactory.getReportFactoryObj().getExtentTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
				ReportFactory.getReportFactoryObj().getExtentTest().fail("Test Case Failed"+result.getName(),
									MediaEntityBuilder.createScreenCaptureFromPath(df.getScreenshot()).build());
				reportMessage.fail(result.getThrowable());
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("couldn't save the screenshot " + e.getMessage());
			} 
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			try {
				ReportFactory.getReportFactoryObj().getExtentTest().log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
				ReportFactory.getReportFactoryObj().getExtentTest().pass("Test Case Passed :-"+result.getName());
				
		} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("couldn't save the screenshot " + e.getMessage());
			} 
		}
		//df.removeDriver();
		//driver.close();
		driver.quit();
		report.flush();
	}
	

	
	@AfterSuite(alwaysRun=true)
	public void publishReport()
	{

		report.flush();
	}
}
