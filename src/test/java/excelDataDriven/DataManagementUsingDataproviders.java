package excelDataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataManagementUsingDataproviders {
	 @Test(dataProvider = "getData")
	  public void f(String RunMode,String Browser, String UserName, String Pasword) 
	  {
		  
	  }
	 @DataProvider
	  public Object[][] getData() throws Exception 
	  {
		  
		    ExcelAPI e = new ExcelAPI("C:\\Users\\chinmaya\\Desktop\\suitea.xlsx");
			String sheetName = "login";
			String testCaseName = "TestB";
			
			int testStartRowNum=0;
			while(!e.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName))
			{
				testStartRowNum++;
			}
			System.out.println("Test starts  from row :" + testStartRowNum);
			
			
			int colStartRowNum = testStartRowNum+1;
			int dataStartRowNum = testStartRowNum+2;
			
			
			//calculate rows of data
			int rows =0 ;
			while(!e.getCellData(sheetName, 0, dataStartRowNum+rows).equals(""))
			{
				rows++;
			}
			System.out.println("Total rows are : " + rows);
			
			
			
			//calculate total columns
			int cols =0;
			while(!e.getCellData(sheetName, cols, colStartRowNum).equals(""))
			{
				cols++;
			}
			System.out.println("Totla columns are : " + cols);
			
			
			
			//read the test data for matching testcase
			int dataRows=0;
			Object[][] data = new Object[rows][cols];
			
			for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
			{
				for(int cNum=0;cNum<cols;cNum++)
				{
					//System.out.println(e.getCellData(sheetName, cNum, rNum));
					data[dataRows][cNum] = e.getCellData(sheetName, cNum, rNum);
				}
				dataRows++;
			}
			return data;
	    
	  }
	 
	 
}
