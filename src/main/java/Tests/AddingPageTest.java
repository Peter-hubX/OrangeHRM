package Tests;

import Pages.AdminPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import Pages.AddingPage;
import java.util.Random;

public class AddingPageTest extends TestBase {
    private String generatedUsername;  // Store generated username

    public String generateRandomUsername() {
        String base = "Zeus";  // Base username
        int randomNumber = new Random().nextInt(1000);
        generatedUsername = base + randomNumber;
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

//    @Test(dependsOnMethods = "AddNewPerson")
//    @Description("Verify the user exists before deletion")
//    public void verifyUserExists() throws InterruptedException {
//        AdminPageObject = new AdminPage(driver);
//        boolean isFound = AdminPageObject.VerifyAdmin(generatedUsername);
//        Assert.assertTrue(isFound, "User should be present in the table.");
//    }

    @Test(dependsOnMethods = "AddNewPerson")
    @Description("Delete the user that was added")
    public void deleteUser() throws InterruptedException {
        AdminPageObject = new AdminPage(driver);
        boolean isDeleted = AdminPageObject.deleteUser(generatedUsername);
        Assert.assertTrue(isDeleted, "User should be deleted successfully.");
    }
}

//public class AddingPageTest extends TestBase {
//    protected int count;
//    private String generatedUsername;  // Store generated username
//
//    public String generateRandomUsername() {
//        if (count == 0) {
//            String base = "Zeus";  // Base username
//            int randomNumber = new Random().nextInt(1000);
//            generatedUsername = base + randomNumber;
//            count++;
//        }
//        return generatedUsername;
//    }
//
//    String DeleteUserName = generatedUsername;
//
//    AddingPage AddingPageObject;
//    AdminPage AdminPageObject;
//
//    @Test
//    @Description("Test to add a new person with specific details")
//    public void AddNewPerson() throws InterruptedException {
//        AddingPageObject = new AddingPage(driver);
//        setUserRole("Admin");
//        chooseEmployeeName("a", 2);
//        setStatus("Disabled");
//        setUserName(generateRandomUsername()); // Use generated username
//        setPassword("12345678910p");
//        saveDetails();
//    }
//
//    @Step("Set user role to {role}")
//    public void setUserRole(String role) throws InterruptedException {
//        AddingPageObject.UserRole(role);
//    }
//
//    @Step("Choose employee name with name {name} and option {optionNumber}")
//    public void chooseEmployeeName(String name, int optionNumber) throws InterruptedException {
//        AddingPageObject.ChooseName(name, optionNumber);
//    }
//
//    @Step("Set status to {status}")
//    public void setStatus(String status) throws InterruptedException {
//        AddingPageObject.ChooseStatus(status);
//    }
//
//    @Step("Set username to {username}")
//    public void setUserName(String username) {
//        AddingPageObject.UserName(username);
//    }
//
//    @Step("Set password")
//    public void setPassword(String password) {
//        AddingPageObject.Passwords(password);
//    }
//
//    @Step("Save the new person details")
//    public void saveDetails() {
//        AddingPageObject.Save();
//    }
//
////    @Test(dependsOnMethods = "AddNewPerson")
////    @Description("Check if the user has been added successfully")
////    public void Check() throws InterruptedException {
////        AdminPageObject = new AdminPage(driver);
////        AdminPageObject.VerifyAdmin(generatedUsername);
////        System.out.println("User added successfully "+generatedUsername);
////    }
////    @Test(dependsOnMethods = "Check")
//    @Test(dependsOnMethods = "AddNewPerson")
//    @Description("Delete the user that was added")
//    public void deleteUser() throws InterruptedException
//    {
//        AdminPageObject = new AdminPage(driver);
//        AdminPageObject.VerifyAdmin(generatedUsername);
//        boolean isDeleted = AdminPageObject.deleteUser(generatedUsername);
//        Assert.assertTrue(isDeleted, "User should be deleted successfully.");
//    }
//
//
//}
