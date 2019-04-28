package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	public static String TestDatapath="C:\\Users\\Sonia\\Desktop\\Sonia\\SeleniumTDD\\src\\main\\java\\com\\qa\\testdata\\FreeCRMTestData.xlsx";
	public static Workbook workbook;
	public static Sheet sheet;
	public static FileInputStream fis=null;
	
	public static Object[][] getTestData(String sheetname)
	{
		try {
			fis = new FileInputStream(TestDatapath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(i).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return null;
		
	}

}
