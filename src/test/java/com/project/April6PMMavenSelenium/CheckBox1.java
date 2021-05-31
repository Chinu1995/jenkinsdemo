package com.project.April6PMMavenSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class CheckBox1 extends BasePage
{
  
	@BeforeMethod(groups= {"regression","smoke"})
	@Parameters("browser")
	  public void beforeMethod(String bType) throws Exception 
	  //public void beforeMethod() throws Exception 			//from properties file
	  {
		init();
		test = report.startTest("CheckBox1");
		test.log(LogStatus.INFO, "----------------   Started CheckBox1 ------------------------");
		test.log(LogStatus.INFO, "initialising the dependency files...... ");
				
		//launch("chromebrowser","checkboxurl");				//from properties file
		launch(bType,"checkboxurl");
		test.log(LogStatus.INFO, "Opened the Browser : " + p.getProperty("chromebrowser"));
				
		//navigateUrl("checkboxurl");
		test.log(LogStatus.INFO, "Navigated to :- " + childProp.getProperty("checkboxurl"));
	  }
	  
	  
	@Test(groups= {"regression","smoke"})
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
		}
	}
 

  @AfterMethod(groups= {"regression","smoke"})
  public void afterMethod() 
  {
	  report.endTest(test);
	  report.flush();
	  
	  driver.quit();
  }

}
