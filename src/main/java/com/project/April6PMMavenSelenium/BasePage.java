package com.project.April6PMMavenSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	
		public static WebDriver driver;
		public static String projectPath = System.getProperty("user.dir");
		public static Properties p;
		public static FileInputStream fis;
		public static Properties mainProp;
		public static Properties childProp;
		public static Properties orProp;
		public static ExtentReports report;
		public static ExtentTest test;
		public static String filePath;
		
		static 
		{
			Date dt=new Date();
			filePath=dt.toString().replace(":", "_").replace(" ", "_");
		}
		
		public static void init() throws Exception 
		{
			//FileInputStream fis=new FileInputStream("E:\\java21\\SeleniumProject\\data.properties");
			//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\data.properties");
			 fis=new FileInputStream(projectPath+"\\data.properties");
			 p=new Properties();
			p.load(fis);
			
			fis=new FileInputStream(projectPath+"\\environment.properties");
			mainProp=new Properties();
			mainProp.load(fis);
			String e=mainProp.getProperty("env");
			//System.out.println(mainProp.getProperty("env"));
			System.out.println(e);
			
			fis=new FileInputStream(projectPath+"\\"+e+".properties");
			childProp=new Properties();
			childProp.load(fis);
			System.out.println(childProp.getProperty("amazonurl"));
			
			fis=new FileInputStream(projectPath+"\\or.properties");
			orProp =new Properties();
			orProp.load(fis);
			
			
			fis = new FileInputStream(projectPath+"\\log4jconfig.properties");
			PropertyConfigurator.configure(fis);
			
			
			report = ExtentManager.getInstance();
		}
		
		
		
		
		public static void launch(String browser,String url )
		{
			
			//if(p.getProperty(browser, url).equals("chrome"))		//from properties file
				if(browser.equals("chrome"))	//from xml suite
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\log\\chromedriver.exe");
				ChromeOptions option=new ChromeOptions();
				option.addArguments("user-data-dir=C:\\Users\\chinmaya\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
				option.addArguments("--disable-notifications");
				
				driver=new ChromeDriver(option);
			}
			else if(browser.equals("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\geckodriver.exe");
				
				ProfilesIni p=new ProfilesIni();
				FirefoxProfile profile=p.getProfile("aprilFFprofile");
				 
				FirefoxOptions option=new FirefoxOptions();
				option.setProfile(profile);
				
				option.addPreference("dom.webnotifications.enabled", false);
				
				driver = new FirefoxDriver(option);
				
			}
			//driver.get(childProp.getProperty(url));
			//or
			driver.navigate().to(childProp.getProperty(url));
			// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
		}
		
		public static void windowMaximize()
		{
			driver.manage().window().maximize();	
		}
		public static String getwindowTitle()
		{
			String title = driver.getTitle();
			return title;
			
		}
		public static String getApplicationUrl() {
			String url = driver.getCurrentUrl();
			return url;
			
		}
		public static void delCookies() 
		{
			driver.manage().deleteAllCookies();
		}
		public static void windowBack()
		{
			driver.navigate().back();
		}
		
		public static void windowForword()
		{
			driver.navigate().forward();
		}
		
		public static void windowRefresh()
		{
			driver.navigate().refresh();
		}
		
		public static void closeBrowser()
		{
			driver.quit();
		}

		/*
		 * public static void clickElement(String locatorkey) {
		 * //driver.findElement(By.xpath(orProp.getProperty(locatorkey))).click();
		 * getElement(locatorkey);
		 * 
		 * }
		 */
		public static void clickElement(String locatorKey) 
		{
			//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
			getElement(locatorKey).click();
		}

		public static void typeText(String locatorkey, String text)
		{
			//driver.findElement(By.id(orProp.getProperty(locatorkey))).sendKeys(text);
			getElement(locatorkey).sendKeys(text);
		}

		public static void selectOption(String locatorkey, String option)
		{
			
			//driver.findElement(By.id(orProp.getProperty(locatorkey))).sendKeys(option);
			getElement(locatorkey).sendKeys(option);
		}
		
		public static WebElement getElement(String locatorKey) 
		{
			WebElement element=null;
			if(locatorKey.endsWith("_id")) 
			{
				element=driver.findElement(By.id(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_name")) {
				element=driver.findElement(By.name(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_classname")) {
				element=driver.findElement(By.className(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_xpath")) {
				element=driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_css")) {
				element=driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_linktext")) {
				element=driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
			}else if(locatorKey.endsWith("_partiallinktext")) {
				element=driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
			}
			return element;
		}
		
	//   **********************  Verifications    *************************
		
		public static boolean isLinkEqual(String expectedLink) {
			String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
			if(actualLink.equals(expectedLink))
				return true;
			else
				return false;
		}
	//   ******************************  Reportings  **************************
		public static void reportSuccess(String successMsg) {
			test.log(LogStatus.PASS, successMsg);
			
		}

		public static void reportFailure(String failureMsg) throws Exception {
			test.log(LogStatus.FAIL, failureMsg);
			takesScreenshot();
			
		}




		public static void takesScreenshot() throws Exception {
			Date dt=new Date();
			System.out.println(dt);
			String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";	
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileHandler.copy(scrFile, new File(projectPath+"\\failurescreenshots\\"+dateFormat));
			
			test.log(LogStatus.INFO, "Screenshot --->" +test.addScreenCapture(projectPath+"\\failurescreenshots\\"+dateFormat));
		}
		//for explicit wait method
		public void waitForElement(WebElement locator, int timesInSeconds, String typeOfWait) {
			WebDriverWait wait=new WebDriverWait(driver,timesInSeconds) ;
			if(typeOfWait.equals("visibleOfElement")) {
				wait.until(ExpectedConditions.visibilityOf(locator));
			}else if(typeOfWait.equals("elementToClick")) {
				wait.until(ExpectedConditions.elementToBeClickable(locator));
			}
			
		}
	}
