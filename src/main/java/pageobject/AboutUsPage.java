package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import uistore.AboutUsPageUi;
import utility.ExtentReport;
import utility.Logs;

public class AboutUsPage {

	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public AboutUsPage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	
	public void clickBlog() throws IOException, InterruptedException {
		exReport.enterInfoLog("Clicking on Our Blog");
		logs.enterInfoLog("Clicking On Our Blog");
		Thread.sleep(1000);
		webDriver.clickElement(driver, AboutUsPageUi.blog);
		webDriver.switchTab(driver, 1);
		if(webDriver.getCurrentUrl(driver).contains("blog")) {
			exReport.enterPassLogWithSnap("Blog page has opened");
			logs.enterInfoLog("Blog page has opened");
		}else {
			exReport.enterFailLogWithSnap("Blog page didn't open");
			logs.enterErrorLog("Blog page didn't open");
		}
	}
	
	public void clickContatcUs() throws IOException, InterruptedException {
		exReport.enterInfoLog("Clicking on Contact Us");
		logs.enterInfoLog("Clicking on Contact Us");
//	    Thread.sleep(1000);
		webDriver.clickElement(driver, AboutUsPageUi.contactUs);
		if(webDriver.getText(driver, AboutUsPageUi.sectionHeading).contains("Contact Us")){
			exReport.enterPassLog("Contact Us section is open");
			logs.enterInfoLog("Contact Us section is open");
		}else {
			exReport.enterFailLogWithSnap("Contact Us section didn't open");
			logs.enterErrorLog("Contact Us section didn't open");
		}
	}
	
	public void openTwitter() throws IOException, InterruptedException {
		exReport.enterInfoLog("Clicking on twitter icon in contact us");
		logs.enterInfoLog("Clicking on twitter icon in contact us");
		webDriver.clickElement(driver, AboutUsPageUi.twitterLink);
		webDriver.switchTab(driver, 1);
		webDriver.waitUntilPageTitle(driver, "Twitter");
		if(webDriver.getPageTitle(driver).contains("Twitter")) {
			exReport.enterPassLogWithSnap("Twitter has opened");
			logs.enterInfoLog("Twitter has opened");
		}else {
			exReport.enterFailLogWithSnap("Twitter didn't open");
			logs.enterErrorLog("Twitter didn't open");
		}
	}
}
