package Tests;

import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import Pages.AdminPage;
import Pages.DashboardPage;

public class DashboardTest extends TestBase {
    DashboardPage DashboardObject;
    AdminPage AdminPageObject;

    @Test
    @Description("Test for navigating to the Admin page from the Dashboard and adding a new entry")
    public void DashboardTest1() throws InterruptedException {
        initializeDashboardPage();
        goToAdminPage();
        addNewEntryInAdminPage();
    }

    @Step("Initialize the Dashboard page")
    private void initializeDashboardPage() {
        DashboardObject = new DashboardPage(driver);
    }

    @Step("Navigate to the Admin page from Dashboard")
    private void goToAdminPage() throws InterruptedException {
        DashboardObject.AdminPage();
    }

    @Step("Add a new entry in the Admin page")
    private void addNewEntryInAdminPage() {
        AdminPageObject = new AdminPage(driver);
        AdminPageObject.Add();
    }
    @Test
    @Description("Test for navigating to the PIM page from the Dashboard")
    public void PIMTest() throws InterruptedException
    {
        DashboardObject = new DashboardPage(driver);
        DashboardObject.PIMPage();
    }
}
