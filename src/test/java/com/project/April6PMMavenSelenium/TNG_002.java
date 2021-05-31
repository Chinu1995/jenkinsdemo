package com.project.April6PMMavenSelenium;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TNG_002 extends BasePage {
 
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  init();
	  test = report.startTest("Tc_005");
		//report.startTest("Tc_005");
		//test.log(LogStatus.INFO, "Init the Properties files....");
		test.log(LogStatus.INFO, "Init the Properties files....");
		
		launch("chromebrowser","amazonurl");
		test.log(LogStatus.INFO, "Opened the Browser : " + p.getProperty("chromebrowser"));
		test.log(LogStatus.PASS, "Opened the Url : " + childProp.getProperty("amazonurl"));
  }

  @Test
  public void amazon() {
	  windowMaximize();
		test.log(LogStatus.INFO, "Maximized the window....");
		
		selectOption("amazondropdown_id","Books");
		test.log(LogStatus.PASS, "Selected the option Books by using Locator :- " + orProp.getProperty("amazondropdown_id"));
		
		typeText("amazonsearchtextbox_id","Harry Potter");
		test.log(LogStatus.INFO, "Entered the test HarryPotter By using the locator :-" + orProp.getProperty("amazonsearchtextbox_id"));
		
		clickElement("amazonsearch_xpath");
		test.log(LogStatus.PASS, "Clicked on amazon search button By using locatoer :- "+ orProp.getProperty("amazonsearch_xpath"));	
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  report.endTest(test);
		report.flush();
  }

}
