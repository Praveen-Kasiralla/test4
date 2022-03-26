package pageobject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import uistore.PropertiesListPageUi;
import utility.ExtentReport;
import utility.Logs;

public class PropertiesListPage {
	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public PropertiesListPage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	
	public void selectDisplayMethod(String displayOption) throws IOException, InterruptedException {
		exReport.enterInfoLog("Clicking on "+displayOption+" display");
		logs.enterInfoLog("Clicking on "+displayOption+" display");
		By displayMethod = displayOption.equals("map")? PropertiesListPageUi.map:PropertiesListPageUi.list;
		webDriver.clickElement(driver, displayMethod);
		Thread.sleep(1000);
		if(webDriver.getClassName(driver, displayMethod).contains("active")) {
			exReport.enterPassLog(displayOption+" is selected");
			logs.enterInfoLog(displayOption+" is selected");
		}else {
			exReport.enterFailLogWithSnap(displayOption+" is not selected");
			logs.enterErrorLog(displayOption+" is not selected");
		}
	}
	
	public void fullscreen() throws InterruptedException, IOException {
		exReport.enterInfoLog("Clicking on fullscreen button on the map");
		logs.enterInfoLog("Clicking on fullscreen button on the map");
		Thread.sleep(1000);
		webDriver.clickElement(driver, PropertiesListPageUi.fullscreen);
		exReport.enterPassLogWithSnap("Map has opened in fullscreen");
		logs.enterInfoLog("Map has opened in fullscreen");
	}
	
	public void clickArtical() throws IOException {
		exReport.enterInfoLog("Clicking on a property artical");
		logs.enterInfoLog("Clicking on a property artical");
		String currentUrl = webDriver.getCurrentUrl(driver);
		webDriver.clickElement(driver, PropertiesListPageUi.propertyArticle);
		webDriver.switchTab(driver, 1);
		if(!webDriver.getCurrentUrl(driver).equals(currentUrl)) {
			exReport.enterPassLog("Property article opened in another page");
			logs.enterInfoLog("Property article opened in another page");
		}else {
			exReport.enterFailLogWithSnap("Property article has not opened");
			logs.enterErrorLog("Property article has not opened");
		}
	}
}
