package rough;

import com.narnaul.utils.Constants;
import com.narnaul.utils.ExcelReader;

public class ReadingExcelData
{

	public static void main(String[] args)
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
		int testCols=0; 
		// checking total cols in test case
		while(!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals(""))
		{
			testCols++;
		}
		
		System.out.println("Total columns are :"+ testCols);
		
		//printing data
		
		for( int rNum =dataStartRowNum ; rNum < (dataStartRowNum+testRows); rNum++)
		{
			for( int cNum= 0; cNum<testCols; cNum++)
			{
				System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
			}
		}
	}
}
