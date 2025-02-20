package Tests;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.PageBase;
import Pages.AdminPage;

public class LoginTest extends TestBase {

    LoginPage LoginPageObject;

    @Test
    @Description("Test for logging in and navigating to Admin page to add a new entry")
    public void LoginTest1() throws InterruptedException {

        initializeLoginPage();
        login("Admin", "admin123");
        ClickLoginButton();
    }

    @Step("Initialize the login page")
    private void initializeLoginPage() {
        LoginPageObject = new LoginPage(driver);
    }

    @Step("Log in with username: {username} and password: {password}")
    private void login(String username, String password) throws InterruptedException {
        LoginPageObject.LoginData(username, password);
        Thread.sleep(3000);
    }
    @Step("Click on Login Button")
    private void ClickLoginButton() throws InterruptedException
    {
        LoginPageObject.clickLoginButton();
    }

}
