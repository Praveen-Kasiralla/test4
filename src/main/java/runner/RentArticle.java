package runner;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.PropertiesListPage;
import pageobject.PropertyPage;
import utility.BaseClass;
import utility.ConfigReader;

public class RentArticle extends BaseClass {

	public HomePage home;
	public PropertiesListPage propertyList;
	public PropertyPage property;
	public HashMap<String, String> searchData;

	@Test(priority = 0)
	public void setUp() {
		logs.createLogger(RentArticle.class);
		home = new HomePage(driver, webDriver, exReport);
		propertyList = new PropertiesListPage(driver, webDriver, exReport);
		property = new PropertyPage(driver, webDriver, exReport);
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
		searchData = excel.getExcelData(ConfigReader.getRentData(), 1);
	}
	
	@Test(priority = 2)
	public void selectSearchType() throws IOException {
		exReport.createNewTestReport("Search type");
		home.selectSearchType(searchData.get("Search Type"));
	}
	
	@Test(priority = 3)
	public void selectCity() throws IOException {
		exReport.createNewTestReport("Select City");
		home.selectCity(searchData.get("City"));
	}
	
	@Test(priority = 4)
	public void selectRentPropertyType() throws InterruptedException, IOException {
		exReport.createNewTestReport("Rent Property Type");
		home.selectRentType(searchData.get("Radio"));
//		Thread.sleep(1000);
	}
	
	@Test(priority = 5)
	public void optionFromDropDown() throws InterruptedException, IOException {
		exReport.createNewTestReport("Select options From dropdown");
		home.dropDown(2, searchData.get("Dropdown2"));
		home.dropDown(3, searchData.get("Dropdown3"));
	}
	
	@Test(priority = 6)
	public void selectLocalityAndSearch() throws InterruptedException, IOException {
		exReport.createNewTestReport("Search");
		home.typeAndSearch(searchData.get("Locality"));
	}
	
	@Test(priority = 7)
	public void clickArticle() throws IOException, InterruptedException {
		exReport.createNewTestReport("Click Article");
		propertyList.clickArtical();
	}
	
	@Test(priority = 8)
	public void seePhotos() throws IOException {
		exReport.createNewTestReport("See Photos");
		property.photos();
	}
}
