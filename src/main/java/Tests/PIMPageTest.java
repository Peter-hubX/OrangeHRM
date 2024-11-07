package Tests;

import Pages.PIMPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class PIMPageTest extends TestBase
{
    PIMPage PIMPageObject;
    @Test
    @Description("Test for PIMPage")
    public void AddNewEmployee() {
        PIMPageObject = new PIMPage(driver);
        PIMPageObject.addEmployee();
        PIMPageObject.Fill_Employee_Data("John", "Doe", "Smith");
    }
}
