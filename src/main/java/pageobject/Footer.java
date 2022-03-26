package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import uistore.FooterUi;
import utility.ExtentReport;
import utility.Logs;

public class Footer {
	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public Footer(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(Footer.class);
	}
	
	public void clickEmiCalculator() throws IOException, InterruptedException {
		exReport.enterInfoLog("Clicking on emi calculator");
		logs.enterInfoLog("Clicking on emi calculator");
		webDriver.scrollUntilVisible(driver, FooterUi.emiCalculator);
		Thread.sleep(1000);
		webDriver.clickElement(driver, FooterUi.emiCalculator);
		webDriver.switchTab(driver, 1);
		if(webDriver.getPageTitle(driver).contains("EMI Calculator")) {
			exReport.enterPassLogWithSnap("Emi calculator page has opened");
			logs.enterInfoLog("Emi calculator page has opened");
		}else {
			exReport.enterFailLogWithSnap("Emi Calculator page has not opened");
			logs.enterErrorLog("Emi Calculator page has not opened");
		}
	}
	
	public void clickAboutUs() throws IOException, InterruptedException {
		exReport.enterInfoLog("Clicking on About Us");
		logs.enterInfoLog("Clicking on About Us");
		webDriver.scrollUntilVisible(driver, FooterUi.aboutUs);
		Thread.sleep(1000);
		webDriver.clickElement(driver, FooterUi.aboutUs);
		if(webDriver.getCurrentUrl(driver).contains("about-us")) {
			exReport.enterPassLog("About Us page has opened");
			logs.enterInfoLog("About Us page has opened");
		}else {
			exReport.enterFailLogWithSnap("About Us page has not opened");
			logs.enterErrorLog("About Us page has not opened");
		}
	}
}
