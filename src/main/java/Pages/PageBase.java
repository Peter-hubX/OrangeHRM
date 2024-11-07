package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageBase 
{
	protected WebDriver driver;
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Method to click a button
	public void clickButton(WebElement button) {
		button.click();
	}
	
	// Method to set text in a text element
	public void setTextElementText(WebElement textElement, String value) {
		textElement.clear();  // Clear existing text before entering new text
		textElement.sendKeys(value);  // Enter the new text
	}
	
}
