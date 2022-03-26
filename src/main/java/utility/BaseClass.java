package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pageobject.Footer;
import pageobject.HomePage;
import reusable.WebDriverHelper;

public class BaseClass {

	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExcelData excel;
	public String browser;
	public ExtentReport exReport;
	public Logs logs;
	public HomePage home;
	public Footer bestSeller;

	@BeforeTest
	public void required() throws IOException {
		webDriver = new WebDriverHelper();
		excel = new ExcelData();
		logs = new Logs();

	}

	@Parameters("browser")
	@BeforeClass
	public void driverSetUp(String browse) throws IOException {
		browser = browse;
		if (ConfigReader.getBrowser(browser).contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (ConfigReader.getBrowser(browser).equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		webDriver.implicitWait(driver, 10);
		exReport = new ExtentReport(driver);
		logs.createLogger(BaseClass.class);
		home = new HomePage(driver, webDriver, exReport);
		bestSeller = new Footer(driver, webDriver, exReport);
	}

	@AfterClass
	public void driverExit() throws IOException {
		exReport.flush();
		driver.quit();
	}
}
