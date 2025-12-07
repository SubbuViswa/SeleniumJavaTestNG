package com.subbu.factory;

import com.aventstack.extentreports.ExtentTest;

public class ReportFactory {

	public static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	private ReportFactory()
	{
		//do nothing so that it can not be initialized from outside.
	}
	
	private static ReportFactory rptFactoryObj=new ReportFactory();
	
	public static ReportFactory getReportFactoryObj()
	{
		return rptFactoryObj;
	}
	
	
	public ExtentTest getExtentTest()
	{
		return extentTest.get();
	}
	
	public void setExtentTest(ExtentTest extentParam)
	{
		extentTest.set(extentParam);
	}
	
}
