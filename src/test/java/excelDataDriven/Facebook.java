package excelDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		ExcelAPI e = new ExcelAPI("C:\\Users\\chinmaya\\Desktop\\testdata.xlsx");
		
		//driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", 1));
		
		
		//driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", 1));
		for(int i=1;i<e.getRowCount("login");i++)
		{
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", i));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", i));
			
			Thread.sleep(2000);
		}
	}

}
