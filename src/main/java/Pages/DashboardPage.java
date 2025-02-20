package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Visibility;
import java.time.Duration;

public class DashboardPage extends PageBase
{
	protected WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		super(driver);

	}
	
	@FindBy(xpath = "//span[text()='Admin']")
    WebElement Admin;

	@FindBy(xpath = "//span[text()='PIM']")
	WebElement PIM;
    
    public void AdminPage() throws InterruptedException
    {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Admin));
    	Admin.click();
    }

	public void PIMPage() throws InterruptedException
	{
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(PIM));
		PIM.click();
	}
}
