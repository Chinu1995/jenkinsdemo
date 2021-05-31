package task;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class Amazon {
	 WebDriver driver;
	@BeforeMethod
	  public void beforeMethod()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chinmaya\\Desktop\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
	  }
  @Test
  public void login() {
	  driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).click();
	driver.findElement(By.id("ap_email")).sendKeys("prustychinmaya294@gmail.com");
	driver.findElement(By.id("continue")).click();
	driver.findElement(By.id("ap_password")).sendKeys("7894696444");
	driver.findElement(By.id("signInSubmit")).click();
	//driver.findElement(By.xpath("//*[@id=\"ap-account-fixup-phone-skip-link\"]")).click();
	//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Headphones");
	//driver.findElement(By.id("nav-search-submit-button")).click();
	//driver.findElement(By.className("s-image")).click();
	//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[3]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/a[1]/div[1]/img[1]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
    searchBox.click();
    searchBox.sendKeys("Headphones"+Keys.ENTER);
    Actions action = new Actions(driver);
    List<WebElement> bestSellers = driver.findElements(By.xpath("//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div[1]"));
    for(int i=1;i<=bestSellers.size();i++) {
        //action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div['"+i+"']")))).build().perform();
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div['"+i+"']"))).click();
    	action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div[1])[" +i +"]")))).build().perform();
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Best Seller']/ancestor::div[@class='sg-row']/following-sibling::div[@class='sg-row']/child::div[1])[" +i +"]"))).click();
    	
    	//removing checkboxes 
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sims-fbt-form\"]/div[2]/fieldset/ul/li[2]/span/span/div/label/input"))).click(); 
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sims-fbt-form\"]/div[2]/fieldset/ul/li[3]/span/span/div/label/input"))).click(); 
    	
    	//add to cart
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"a-autoid-17\"]/span/input"))).click(); 
    	
        //System.err.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Added to Cart')]"))).getText());
    	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'uss-o-close-icon uss-o-close-icon-medium') or contains(@class,'a-link-normal close-button')]"))).click();
    	// wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.uss-o-close-icon.uss-o-close-icon-medium"))).click();
        driver.navigate().back();
        //driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().refresh();
        System.err.println("try to find next best seller item ");
    }
		
	}
	  
  

 

}
