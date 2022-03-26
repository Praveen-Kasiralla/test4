package runner;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobject.Footer;
import pageobject.HomePage;
import pageobject.WalletPage;
import utility.BaseClass;
import utility.ConfigReader;

public class Wallet extends BaseClass {

	public HomePage home;
	public Footer footer;
	public WalletPage wallet;

	@Test(priority = 0)
	public void setUp() {
		logs.createLogger(AboutUs.class);
		home = new HomePage(driver, webDriver, exReport);
		footer = new Footer(driver, webDriver, exReport);
		wallet = new WalletPage(driver, webDriver, exReport);
	}

	@Test(priority = 1)
	public void openNoDroker() throws InterruptedException, IOException {
		webDriver.setSize(driver, 300, 1000);
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
	public void openMenu() throws IOException {
		exReport.createNewTestReport("Open Menu");
		home.clickBurgerMenu();
	}
	
	@Test(priority = 3)
	public void openWallet() throws IOException {
		exReport.createNewTestReport("Open Wallet");
		home.clickWallet();
	}
	
	@Test(priority = 4)
	public void joinClub() throws IOException {
		exReport.createNewTestReport("Join Club");
		wallet.clickClub();
	}

}
