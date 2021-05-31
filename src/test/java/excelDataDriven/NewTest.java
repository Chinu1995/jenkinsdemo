package excelDataDriven;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	@Test(dataProvider = "getData")
	  public void f(Hashtable<String, String> str) 
	  {
		
		System.out.println(str.get("Browser"));
		
       }
  @DataProvider
  public Object[][] getData() throws Exception 
  {
	    ExcelAPI e = new ExcelAPI("C:\\Users\\chinmaya\\Desktop\\suitea.xlsx");
		String sheetName = "login";
		String testCaseName = "LoginTest";
		
		return DataUtils.getTestData(e, sheetName, testCaseName);
  }
  
}
