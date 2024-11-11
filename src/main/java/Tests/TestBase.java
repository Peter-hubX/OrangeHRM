package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.testng.AllureTestNg;

import java.io.File;
import java.io.IOException;

@Listeners({AllureTestNg.class})
public class TestBase 
{
    protected static WebDriver driver;
	public  static WebDriver getDriver()
	{
		return driver;
	}
	@BeforeSuite
	public void BeforeTesting() 
	{
		
        WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@AfterMethod
	public void Screenshot (ITestResult result) throws IOException {
		if(ITestResult.FAILURE == result.getStatus())
		{
			TakesScreenshot TakeSS = (TakesScreenshot) driver;
			File source = TakeSS.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"/ScreenShots/"+result.getName()+".png"));
		}
	}}

