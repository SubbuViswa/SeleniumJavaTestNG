package com.subbu.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Rerun implements IRetryAnalyzer
{

	int minRetryCount=2;

	@Override
	public boolean retry(ITestResult result) {
		if(minRetryCount<=Constants.MAX_RETRY_COUNT)
		{
			System.out.println("Following Test is failing :-"+ result.getName());
			minRetryCount++;
			return true;
		}
		return false;
	}

}
