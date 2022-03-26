package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import uistore.PropertyPageUi;
import utility.ExtentReport;
import utility.Logs;

public class PropertyPage {

	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public PropertyPage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	
	public void photos() throws IOException {
		exReport.enterInfoLog("Clicking on photos");
		logs.enterInfoLog("Clicking on photos");
		webDriver.clickElement(driver, PropertyPageUi.photos);
		if(webDriver.isDisplayed(driver, PropertyPageUi.photoLightbox)) {
			exReport.enterPassLogWithSnap("Photo Lighbox of the property has opened");
			logs.enterInfoLog("Photo Lighbox of the property has opened");
		}else {
			exReport.enterFailLogWithSnap("Photo Lighbox didn't open");
			logs.enterErrorLog("Photo Lighbox didn't open");
		}
	}
}
