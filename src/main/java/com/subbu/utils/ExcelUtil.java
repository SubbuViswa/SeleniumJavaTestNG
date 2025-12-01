package com.subbu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static String TEST_DATA_SHEET=Constants.TUTORIAL_NINJA_ExcelData;
	private static Workbook book;
	private static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) throws FileNotFoundException
	{
		Object data[][]=null;
		FileInputStream ip= new FileInputStream(TEST_DATA_SHEET);
		try {
			book=WorkbookFactory.create(ip);
			sheet=book.getSheet(sheetName);
			data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	


	//workbookName - Spread sheet path (Eg: ./src/test/resource/TestData/Users.xlsx
		//sheetName - workbook sheet name
		public static Object[][] getTestDataSheetData(String workbookPath,String sheetName) throws FileNotFoundException
		{
			Object data[][]=null;
			FileInputStream ip= new FileInputStream(workbookPath);
			try {
				book=WorkbookFactory.create(ip);
				sheet=book.getSheet(sheetName);
				data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				for(int i=0;i<sheet.getLastRowNum();i++) {
					for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
					{
						data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					}
				}
				
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
		}

}
