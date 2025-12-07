package com.subbu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTimeUtils {

	
	public static String getCurrentDateTime()
	{
		SimpleDateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss"); 
		Date currentDate = new Date ();
		return customFormat.format(currentDate);
	}
		
}
