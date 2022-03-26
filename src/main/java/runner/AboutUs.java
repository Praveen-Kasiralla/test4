package runner;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobject.AboutUsPage;
import pageobject.Footer;
import pageobject.HomePage;
import utility.BaseClass;
import utility.ConfigReader;

public class AboutUs extends BaseClass {

	public HomePage home;
	public Footer footer;
	public AboutUsPage aboutUs;

	@Test(priority = 0)
	public void setUp() {
		logs.createLogger(AboutUs.class);
		home = new HomePage(driver, webDriver, exReport);
		footer = new Footer(driver, webDriver, exReport);
		aboutUs = new AboutUsPage(driver, webDriver, exReport);
	}

	@Test(priority = 1)
	public void openNoDroker() throws InterruptedException, IOException {
		exReport.createNewTestReport("Open NoBroker");
		logs.enterInfoLog("Open NoBroker");
		exReport.enterInfoLog("Opening NoBroker.in");
		webDriver.openPage(driver, ConfigReader.getUrl());
		if (webDriver.getCurrentUrl(driver).equals(ConfigReader.getUrl())) {
			exReport.enterPassLogWithSnap("NoBroker as opened");
			logs.enterInfoLog("NoBroker as opened");
		} else {
			exReport.enterFailLogWithSnap("NoBroker as opened");
		}
	}
	
	@Test(priority = 2)
	public void clickAboutUs() throws IOException, InterruptedException {
		exReport.createNewTestReport("Click About Us");
		footer.clickAboutUs();
	}
	
	@Test(priority = 3)
	public void OpenTwitter() throws IOException, InterruptedException {
		exReport.createNewTestReport("Open Twitter");
		aboutUs.clickContatcUs();
		aboutUs.openTwitter();
	}
}
