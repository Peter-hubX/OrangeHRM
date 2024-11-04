package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.testng.AllureTestNg;

@Listeners({AllureTestNg.class})
public class TestBase 
{
    public static WebDriver driver;	
	@BeforeSuite
	public void BeforeTesting() 
	{
		
        WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	}

