package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import reusable.WebDriverHelper;
import uistore.WalletPageUi;
import utility.ExtentReport;
import utility.Logs;

public class WalletPage {
	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public WalletPage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	
	public void clickClub() throws IOException {
		exReport.enterInfoLog("Clicking on Join club");
		logs.enterInfoLog("Cliking on Join club");
		webDriver.waitUntilClikable(driver, WalletPageUi.joinClub);
		webDriver.clickElement(driver, WalletPageUi.joinClub);
		if(webDriver.getCurrentUrl(driver).contains("club")) {
			exReport.enterPassLogWithSnap("Wallet Club page has opened");
			logs.enterInfoLog("Wallet club page has opened");
		}else {
			exReport.enterFailLogWithSnap("Wallet Club page did not open");
			logs.enterErrorLog("Wallte club page did not open");
		}
		
	}
}
