package Tests;

import Pages.AdminPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import Pages.AddingPage;

import java.io.IOException;
import java.util.Random;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class AddingPageTest extends TestBase {
    protected int count;
    private String generatedUsername;  // Store generated username

    public String generateRandomUsername() {
        if (count == 0) {
            String base = "Zeus";  // Base username
            int randomNumber = new Random().nextInt(1000);
            generatedUsername = base + randomNumber;
            count++;
        }
        return generatedUsername;
    }

    AddingPage AddingPageObject;
    AdminPage AdminPageObject;

    @Test
    @Description("Test to add a new person with specific details")
    public void AddNewPerson() throws InterruptedException {
        AddingPageObject = new AddingPage(driver);
        setUserRole("Admin");
        chooseEmployeeName("a", 2);
        setStatus("Disabled");
        setUserName(generateRandomUsername()); // Use generated username
        setPassword("12345678910p");
        saveDetails();
    }

    @Step("Set user role to {role}")
    public void setUserRole(String role) throws InterruptedException {
        AddingPageObject.UserRole(role);
    }

    @Step("Choose employee name with name {name} and option {optionNumber}")
    public void chooseEmployeeName(String name, int optionNumber) throws InterruptedException {
        AddingPageObject.ChooseName(name, optionNumber);
    }

    @Step("Set status to {status}")
    public void setStatus(String status) throws InterruptedException {
        AddingPageObject.ChooseStatus(status);
    }

    @Step("Set username to {username}")
    public void setUserName(String username) {
        AddingPageObject.UserName(username);
    }

    @Step("Set password")
    public void setPassword(String password) {
        AddingPageObject.Passwords(password);
    }

    @Step("Save the new person details")
    public void saveDetails() {
        AddingPageObject.Save();
    }

    @Test(dependsOnMethods = "AddNewPerson")
    @Description("Check if the user has been added successfully")
    public void Check() throws InterruptedException {
        AdminPageObject = new AdminPage(driver);
        AdminPageObject.VerifyAdmin(generatedUsername);
        System.out.println("User added successfully"+generatedUsername);
    }


}
