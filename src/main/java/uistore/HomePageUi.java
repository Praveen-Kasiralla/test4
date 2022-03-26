package uistore;

import org.openqa.selenium.By;

public class HomePageUi {

	public static By searchIcon = By.cssSelector("[class='pv-icon pv-icon-search']"); 
	public static By searchBox = By.cssSelector("#search_38712");
	public static By automotive = By.cssSelector("[class='p-icon-car--32 p-n02v3__m2icon']");
	public static By carLights = By.cssSelector("a[href='https://www.philips.co.in/c-m-au/car-lights']");
	public static By footerProductLink = By.cssSelector("[href='/c-m/consumer-products']");
	public static By mobileMenu = By.cssSelector(".p-n02v3__mzhamburger--open");
	public static By mobileAutomotive = By.cssSelector("[data-track-navdest='consumer:products:automotive']");
	public static By mobileCar = By.xpath("//*[text()='Car']");
	
	//nobroker
	public static By buy = By.cssSelector(".nb__17yFj:nth-child(1)");
	public static By rent = By.cssSelector(".nb__17yFj:nth-child(2)");
	public static By commercial = By.cssSelector(".nb__17yFj:nth-child(3)");
	public static By searchBar = By.cssSelector("#listPageSearchLocality");
	public static By searchDropdown = By.cssSelector("[class='autocomplete-dropdown-container']");
	public static By searchButton = By.cssSelector("[class='prop-search-button btn btn-primary btn-lg']");
	public static By selectedLocality = By.cssSelector("#selectedLocalities");
	
	//three
	public static By selectCity = By.xpath("(//*[@id='searchCity'])[1]");
	public static By selectCityMenu = By.cssSelector("[class='css-kj6f9i-menu nb-select__menu']");
	public static By dropDown2 = By.xpath("(//*[@id='searchCity'])[2]");
	public static By dropDown3 = By.xpath("(//*[@id='searchCity'])[3]");
	public static String option;
	//
	
	public static By newBuilders = By.cssSelector("#exclusive_deals");
	public static By fullHouse = By.cssSelector("#RENT");
	public static By pg = By.cssSelector("#PG");
	public static By flatmates = By.cssSelector("#SHARED");
	public static By commercialRent = By.cssSelector("#COMMERCIAL_RENT");
	public static By commercialBuy = By.cssSelector("#COMMERCIAL_BUY");
	
	public static By dropDownMenuOption() {
		return By.xpath("//*[text()='"+option+"']");
	}
	
	public static By burgerMenu = By.cssSelector("[class='hidden tp:flex absolute left-1.5p']");
	public static By nbCashWallet = By.xpath("//*[text()='NBcash Wallet']");
	public static By walletSummary = By.cssSelector("#wallet");
	public static By homeServices = By.xpath("//*[text()='Home Services']");
	public static By interiors = By.cssSelector("#interiors");
	public static By burgerHome = By.cssSelector("#home");
	

	
}
