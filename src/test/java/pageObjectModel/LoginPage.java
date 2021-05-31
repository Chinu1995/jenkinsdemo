package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(linkText="Sign in") public WebElement Signin;
	
	@FindBy(id="email") public WebElement customerEmail;
	
	@FindBy(id="passwd") public WebElement customerPassword;
	@FindBy(id="SubmitLogin") public WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]") public WebElement getError;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void CustomerLogin() throws Exception 
	{
		Signin.click();
		Thread.sleep(3000);
		customerEmail.sendKeys("qabfggffg@gmail.com");
		customerPassword.sendKeys("password");
		submitLogin.click();
	}
	
	public String verifyLogin()
	{
		return getError.getText();
	}
	

}
