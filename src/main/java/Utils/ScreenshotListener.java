package Utils;

import Tests.TestBase;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener
{
    @Override
    public void onTestFailure(ITestResult result)
    {
        WebDriver driver = TestBase.getDriver(); // Get driver from TestBase
        if (driver != null) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            try
            {
                FileUtils.copyFile(source, new File(System.getProperty("user.dir") + "/ScreenShots/" + result.getName() + "_" + timestamp + ".png"));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}
