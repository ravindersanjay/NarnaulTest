// important and revison needed
package com.narnaul.testcases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.narnaul.utils.Constants;
import com.narnaul.utils.ExcelReader;

public class TestParametrization
{
	@Test(dataProvider = "getData")
	public void testData(Hashtable<String, String> data)
	{
		System.out.println(data.get("RunMode") + " " + data.get("customer") + " " + data.get("currency"));
		//System.out.println(data.get("RunMode") + " " + data.get("firstname") + " " + data.get("lastname"));
		 
	
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		String filePath = "\\src\\test\\resources\\testdata\\BankManagerSuit.xlsx";
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + filePath);

		int rows = excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total Rows: " + rows);

		// find the test case start row
		String TestName = "OpenAccountTest";
		int testCaseRowNum = 1;
		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++)
		{
			String TestCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);

			if (TestCaseName.equalsIgnoreCase(TestName))
			{
				break;
			}

		}
		System.out.println("Test case starts at : " + testCaseRowNum);

		// checking total rows in test case
		int dataStartRowNum = testCaseRowNum + 2;
		System.out.println("DataStartRowNum  :" + dataStartRowNum);

		int testRows = 0;

		while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals(""))
		{
			testRows++;
			System.out.println("Total rows of data are : " + testRows);
		}

		int colStartColNum = testCaseRowNum + 1;
		int testCols = 0;
		
		// checking total cols in test case
		while (!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals(""))
		{
			testCols++;
		}

		System.out.println("Total columns are :" + testCols);

		Object[][] data = new Object[testRows][1];

		// printing data
		int i=0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++)
		{
			Hashtable<String , String> table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < testCols; cNum++)
			{
				// System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
				String testData =  excel.getCellData(Constants.DATA_SHEET, cNum, rNum);
				String colName  =  excel.getCellData(Constants.DATA_SHEET, cNum, colStartColNum);
			
			table.put(colName, testData);
			}
			data[i][0] = table;
			i++;
		}
		return data;
	}
}
