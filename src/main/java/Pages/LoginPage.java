package Pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends PageBase
{
	protected WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(css = "svg.oxd-icon.oxd-main-menu-item--icon")
    WebElement Admin;
    
	@FindBy(xpath = "//input[@name='username']")
	WebElement Username;
	
	@FindBy(name = "password")
	WebElement Password;
	
	@FindBy(className = "orangehrm-login-button")
	WebElement LoginButton;
	
	public void LoginData(String name, String password) throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	    wait.until(ExpectedConditions.visibilityOf(Username));
		setTextElementText(Username, "Admin");
		setTextElementText(Password, "admin123");
		Thread.sleep(2000);
		clickButton(LoginButton);
		Thread.sleep(2000);
	  //  wait.until(ExpectedConditions.visibilityOf(Admin));
		//clickButton(Admin);
	}



}
