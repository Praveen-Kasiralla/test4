package runner;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import pageobject.EmiCalculatorPage;
import pageobject.Footer;
import pageobject.HomePage;
import utility.BaseClass;
import utility.ConfigReader;

public class EmiCalculator extends BaseClass {

	public HomePage home;
	public Footer footer;
	public EmiCalculatorPage calculator;
	public HashMap<String, String> searchData;

	@Test(priority = 0)
	public void setUp() {
		logs.createLogger(EmiCalculator.class);
		home = new HomePage(driver, webDriver, exReport);
		footer = new Footer(driver, webDriver, exReport);
		calculator = new EmiCalculatorPage(driver, webDriver, exReport);
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
		searchData = excel.getExcelData(ConfigReader.getEmiData(), 1);
	}
	
	@Test(priority = 2)
	public void emiFooterLink() throws IOException, InterruptedException {
		exReport.createNewTestReport("EMI Calculator Page");
		footer.clickEmiCalculator();
	}
	
	@Test(priority = 3)
	public void loanAmount() throws IOException, InterruptedException {
		exReport.createNewTestReport("Enter Loan Amount");
		System.out.println(searchData.get("Loan Amount")+"  sdjhskjfhskfjh");
		calculator.enterLoanAmount(searchData.get("Loan Amount"));
	}
	
	@Test(priority = 4)
	public void rateOfInterest() throws IOException, InterruptedException {
		exReport.createNewTestReport("Enter Rate Of Interest");
		calculator.enterRateOfInterest(searchData.get("Rate Of Interest"));
	}
	
	@Test(priority = 5)
	public void loanTenure() throws IOException, InterruptedException {
		exReport.createNewTestReport("Enter Loan Tenure");
		calculator.enterLoanTenure(searchData.get("Loan Tenure"));
	}
	@Test(priority = 6)
	public void output() throws IOException {
		exReport.createNewTestReport("Emi Output");
		calculator.emiCalculated();
	}
}
