package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Tests.AddingPageTest;


public class AdminPage extends PageBase
{
	AddingPageTest AddingPageTestObject;
	protected WebDriver driver;
	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement Add;

	@FindBy(xpath = "//div[@class='oxd-table']")
	List<WebElement> Table;

	@FindBy(xpath = "//div[@class='oxd-table']//div[@role='row']")
	List<WebElement> tableRows;

	@FindBy(xpath = "//button[@class = 'oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
	WebElement delete;



	public void Add()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(Add));
		clickButton(Add);
	}


	public boolean deleteUser(String randomUsername) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));

		for (WebElement row : tableRows) {
			try {
				WebElement deleteButton = row.findElement(By.xpath(
						".//div[contains(@class, 'oxd-table-cell')]//*[contains(text(), '" + randomUsername + "')]/ancestor::div[@role='row']//button[i[contains(@class, 'bi-trash')]]"
				));

				wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
				deleteButton.click();
				System.out.println("🗑️ Deleted user: " + randomUsername);
				wait.until(ExpectedConditions.visibilityOf(delete));
				clickButton(delete);
				return true;
			} catch (Exception e) {
				System.out.println("⚠ User not found in this row.");
			}
		}

		System.out.println("❌ User NOT deleted: " + randomUsername);
		return false;
	}


}
