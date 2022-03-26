package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import reusable.WebDriverHelper;
import uistore.EmiCalculatorPageUi;
import utility.BaseClass;
import utility.ExtentReport;
import utility.Logs;

public class EmiCalculatorPage extends BaseClass {
	public WebDriver driver;
	public WebDriverHelper webDriver;
	public ExtentReport exReport;
	public Logs logs = new Logs();

	public EmiCalculatorPage(WebDriver driverr, WebDriverHelper webDriverr, ExtentReport exReportt) {
		driver = driverr;
		webDriver = webDriverr;
		exReport = exReportt;
		logs.createLogger(HomePage.class);
	}
	
	public void enterLoanAmount(String amount) throws IOException, InterruptedException {
		exReport.enterInfoLog("Entering "+amount+" loan amount");
		logs.enterInfoLog("Entering "+amount+" loan amount");
		webDriver.clearText(driver, EmiCalculatorPageUi.loanAmount);
		webDriver.sendText(driver, EmiCalculatorPageUi.loanAmount, amount);
//		if(webDriver.getText(driver, EmiCalculatorPageUi.loanAmount).equals(amount)) {
//			exReport.enterPassLog(amount+" is entered in loan amount");
//			logs.enterInfoLog(amount+" is entered in loan amount");
//		}else {
//			exReport.enterFailLogWithSnap(amount+" is not entered in loan amount");
//			logs.enterErrorLog(amount+" is not entered in loan amount");
//		}
	}
	
	public void enterRateOfInterest(String interest) throws IOException, InterruptedException {
		exReport.enterInfoLog("Entering "+interest+" rate of interest");
		logs.enterInfoLog("Entering "+interest+" rate of interest");
		webDriver.clearText(driver, EmiCalculatorPageUi.rateOfInterest);
		webDriver.sendText(driver, EmiCalculatorPageUi.rateOfInterest, interest);
//		if(webDriver.getText(driver, EmiCalculatorPageUi.rateOfInterest).equals(interest)) {
//			exReport.enterPassLog(interest+" is entered in rate of interest");
//			logs.enterInfoLog(interest+" is entered in rate of interest");
//		}else {
//			exReport.enterFailLogWithSnap(interest+" is not entered in rate of interest");
//			logs.enterErrorLog(interest+" is not entered in rate of interest");
//		}
	}
	
	public void enterLoanTenure(String years) throws IOException, InterruptedException {
		exReport.enterInfoLog("Entering "+years+" loan tenure");
		logs.enterInfoLog("Entering "+years+" loan tenure");
		webDriver.clearText(driver, EmiCalculatorPageUi.loanTenure);
		webDriver.sendText(driver, EmiCalculatorPageUi.loanTenure, years);
//		if(webDriver.getText(driver, EmiCalculatorPageUi.loanTenure).equals(years)) {
//			exReport.enterPassLog(years+" is entered in loan tenure");
//			logs.enterInfoLog(years+" is entered in loan tenure");
//		}else {
//			exReport.enterFailLogWithSnap(years+" is not entered in loan tenure");
//			logs.enterErrorLog(years+" is not entered in loan tenure");
//		}
	}
	public void emiCalculated() throws IOException {
		exReport.enterPassLogWithSnap("EMi Output is");
		logs.enterInfoLog("Emi is calculated");
	}
}
