package com.project.April6PMMavenSelenium;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BasePage
	{
		public static ExtentReports report;
		public static ExtentReports getInstance()
		{
			if(report==null) 
			{
				report=new ExtentReports(projectPath+"//HtmlReports//report.html");
				report.loadConfig(new File(projectPath+"//extentconfig.xml"));
				report.addSystemInfo("Selenium Launguage", "3.141.59").addSystemInfo("Environment", mainProp.getProperty("env"));
			}
			return report;
			
		}
	
	
	
}
