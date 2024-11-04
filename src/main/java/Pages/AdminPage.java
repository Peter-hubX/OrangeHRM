package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import Tests.AddingPageTest;


public class AdminPage extends PageBase
{
	AddingPageTest AddingPageTestObject;
	protected WebDriver driver;
	public AdminPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement Add;

	@FindBy(xpath = "//div[@class='oxd-table']")
	List<WebElement> Table;

	public void Add()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Add));
		clickButton(Add);
	}


	public void VerifyAdmin(String randomUsername) throws InterruptedException {
		Thread.sleep(6000);
		AddingPageTestObject = new AddingPageTest();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(Table));		// Verify the table is displayed and contains the required data.
		boolean found = false;
		for (WebElement option : Table)
		{
			WebElement usernameCell = option.findElement(By.xpath(".//div[@role='cell'][2]"));
			if (usernameCell.getText().equals(randomUsername))
			{
				found = true;
				break;

		}
	}
}}
