package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PIMPage extends PageBase
{
    @FindBy(xpath = "//a[text()= 'Add Employee']")
    WebElement addEmployee;
    @FindBy(xpath = "//input[@class= 'oxd-input oxd-input--active orangehrm-firstname']")
    WebElement FirstName;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-middlename']")
    WebElement MiddleName;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
    WebElement LastName;
    @FindBy(xpath = "//button[@class = 'oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement saveButton;

    public PIMPage(WebDriver driver)
    {
        super(driver);
    }

    public void addEmployee()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(addEmployee));
        addEmployee.click();
    }
    public void Fill_Employee_Data(String firstName, String Middlename, String lastname)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(FirstName));
        setTextElementText(FirstName, firstName);
        wait.until(ExpectedConditions.visibilityOf(MiddleName));
        setTextElementText(MiddleName, Middlename);
        wait.until(ExpectedConditions.visibilityOf(LastName));
        setTextElementText(LastName, lastname);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        clickButton(saveButton);

    }

}
