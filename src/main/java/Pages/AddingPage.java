package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingPage extends PageBase
{
	protected WebDriver driver;
	public AddingPage(WebDriver driver)
	{
		super(driver);
	}

    @FindBy(css = "i.oxd-icon.bi-caret-down-fill.oxd-select-text--arrow") 
    WebElement dropdownArrow;
    


    @FindBy(xpath = "//div[@role='option' and contains(@class, 'oxd-select-option')]")
    List<WebElement> options;
    
    @FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class, 'oxd-input-group') and contains(@class, 'oxd-input-field-bottom-space')]//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    WebElement statusDropdownArrow;
    

    
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameInput;
     

     @FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@role='listbox']//div[@role='option']/span[contains(text(), 'Enabled')]")
     WebElement enabledOption;
     
     @FindBy(xpath = "//label[text()='Status']/ancestor::div[contains(@class, 'oxd-input-group')]//div[@role='listbox']//div[@role='option']/span[contains(text(), 'Disabled')]")
     WebElement disabledOption;
     
     @FindBy(xpath = "//div[@role='listbox']//div[@role='option']//span")
     List<WebElement> autoSuggestOptions;
     
     @FindBy(xpath="//label[text()='Username']/following::input[1]")
     WebElement Username;
     
     @FindBy(xpath="//label[text()='Username']/following::input[2]")
     WebElement Password;
     
     @FindBy(xpath="//label[text()='Username']/following::input[3]")
     WebElement ConfirmPassword;
     
     @FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
     WebElement SaveButton;

     @FindBy(xpath = "//div[@class='orangehrm-container']")
     WebElement Table;

     @FindBy(xpath = "//div[@class='orangehrm-container']//div[@role='row']")
     List<WebElement>tableRows;

    public void UserRole(String optionToSelect) throws InterruptedException
    {
        // Click the dropdown arrow to open the dropdown menu
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dropdownArrow));
        
        clickButton(dropdownArrow);

        // Wait until dropdown options are visible
        wait.until(ExpectedConditions.visibilityOfAllElements(options));

        // Iterate over the options to find and click the desired one (Admin or ESS)
        for (WebElement option : options) 
        {
            String optionText = option.getText().trim(); // Get the visible text of the option
        	if (optionText.equals(optionToSelect))
        	{
                option.click();
                break;
        	}}}
    public void ChooseStatus (String Option) throws InterruptedException
    {
        Thread.sleep(2000);
    	statusDropdownArrow.click();
    	WebElement SelectedOption = Option.equals("Enabled")?enabledOption:disabledOption;
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.visibilityOf(SelectedOption));
    	clickButton(SelectedOption);
    }
        	
     public void ChooseName (String name, int OptionNumber) throws InterruptedException 
     {
         Thread.sleep(2000);
    	 employeeNameInput.sendKeys(name);
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	 wait.until(ExpectedConditions.visibilityOfAllElements(autoSuggestOptions));

    	    for (WebElement option : autoSuggestOptions) {
    	        option.getText().trim();
    	    }

    	    // Optionally, select the first option from the suggestions
    	    if (!autoSuggestOptions.isEmpty()) {
    	        autoSuggestOptions.get(OptionNumber).click();
    	    }
    	    else 
    	    {
                System.out.println("Option number out of range.");
            }
    	 
     }
     
     public void UserName(String username)
     {
    	 setTextElementText(Username, username);
     }
     
     public void Passwords(String password)
     {
    	 setTextElementText(Password, password);
    	 setTextElementText(ConfirmPassword, password);

    	 
     }
     public void Save() 
     {
    	 clickButton(SaveButton);
     }}


     


