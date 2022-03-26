package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import uistore.InteriorPageUi;
import utility.ExtentReport;
import utility.Logs;

public class InteriorPage {
	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public InteriorPage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	
	public void clickOnRooms() throws IOException, InterruptedException {
		exReport.enterInfoLog("Clicking on Rooms to see photos");
		logs.enterInfoLog("Clicking on Rooms to see photos");
		webDriver.clickElement(driver, InteriorPageUi.bedroom);
		webDriver.clickElement(driver, InteriorPageUi.livingRoom);
		webDriver.clickElement(driver, InteriorPageUi.viewAll);
		Thread.sleep(1000);
		exReport.enterPassLogWithSnap("Room photos are displayed");
		logs.enterInfoLog("Room photos are displayed");
	}
}
