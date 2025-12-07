package com.subbu.tests;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.subbu.factory.ReportFactory;
import com.subbu.utils.Constants;
import com.subbu.utils.ExcelUtil;


public class Tutorials_Ninja_Test extends BaseTest {
	
	ExtentTest rptMessage;
	
	@Test(enabled=true,groups= {"Demo"})
	public void demoTutorialsNinjaTest() throws InterruptedException {

		reportMessage=report.createTest("Demo Tutorials Ninja Registration");
		ReportFactory.getReportFactoryObj().setExtentTest(reportMessage);
		rptMessage=ReportFactory.getReportFactoryObj().getExtentTest();
		
		ExtentTest selectRegiterPage=rptMessage.createNode("Select Register link from HomePage");
		Assert.assertTrue(registerUserPage.navigateToRegisterPageFromHomePage(selectRegiterPage));;
		
		
		
		ExtentTest enterUserRegistrationDetails=rptMessage.createNode("Enter the user registration details");
		
		try {
			Object excelDataObj[][]=ExcelUtil.getTestDataSheetData(Constants.TUTORIAL_NINJA_ExcelData,"DemoRegisterUserDetails");
			for (int rowIndex = 0; rowIndex<excelDataObj.length; rowIndex++){
				registerUserPage.fillRegistrationDetails(String.valueOf(excelDataObj[rowIndex][0]),String.valueOf(excelDataObj[rowIndex][1]),String.valueOf(excelDataObj[rowIndex][2]),String.valueOf(excelDataObj[rowIndex][3]),String.valueOf(excelDataObj[rowIndex][4]),String.valueOf(excelDataObj[rowIndex][5]),String.valueOf(excelDataObj[rowIndex][6]),enterUserRegistrationDetails);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
