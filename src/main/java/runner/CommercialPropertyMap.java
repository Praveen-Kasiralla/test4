package runner;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.PropertiesListPage;
import utility.BaseClass;
import utility.ConfigReader;

public class CommercialPropertyMap extends BaseClass {

	public HomePage home;
	public PropertiesListPage propertyList;
	public HashMap<String, String> searchData;

	@Test(priority = 0)
	public void setUp() {
		logs.createLogger(CommercialPropertyMap.class);
		home = new HomePage(driver, webDriver, exReport);
		propertyList = new PropertiesListPage(driver, webDriver, exReport);
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
		searchData = excel.getExcelData(ConfigReader.getCommercialData(), 1);
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
	public void selectCommercialPropertyType() throws InterruptedException, IOException {
		exReport.createNewTestReport("Commercial Buy");
		home.selectCommercialType(searchData.get("Radio"));
	}
	
	@Test(priority = 5)
	public void optionFromDropDown() throws InterruptedException, IOException {
		exReport.createNewTestReport("Select options From dropdown");
		home.dropDown(2, searchData.get("Dropdown2"));
	}
	
	@Test(priority = 6)
	public void selectLocalityAndSearch() throws InterruptedException, IOException {
		exReport.createNewTestReport("Search");
		home.typeAndSearch(searchData.get("Locality"));
	}
	
	@Test(priority = 7)
	public void swithMapAndZoom() throws IOException, InterruptedException {
		exReport.createNewTestReport("Swith Map And Zoom");
		propertyList.selectDisplayMethod("map");
		propertyList.fullscreen();
	
	}
}
