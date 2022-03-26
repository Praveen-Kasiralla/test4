package reusable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {

	public void clickElement(WebDriver driver, By element) throws ElementNotInteractableException {
		driver.findElement(element).click();
	}

	public void clearText(WebDriver driver, By element) throws ElementNotInteractableException {
		driver.findElement(element).clear();
	}

	public void sendText(WebDriver driver, By element, String value) throws ElementNotInteractableException {
		driver.findElement(element).sendKeys(value);
	}

	public void sendText(WebDriver driver, By element, String value, Keys key) {
		driver.findElement(element).sendKeys(value, key);
	}

	public String getText(WebDriver driver, By element) {
		return driver.findElement(element).getText();
	}
	
	public String getClassName(WebDriver driver, By element) {
		return driver.findElement(element).getAttribute("class");
	}
	
	public String getTestOf(WebDriver driver, By element, String attribut) {
		return driver.findElement(element).getAttribute(attribut);
	}

	public void switchTab(WebDriver driver, int index) {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(index));
	}

	public void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void openPage(WebDriver driver, String Url) {
		driver.get(Url);
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public boolean isSelected(WebDriver driver, By element) {
		return driver.findElement(element).isSelected();
	}
	
	public boolean isDisplayed(WebDriver driver, By element) {
		return driver.findElement(element).isDisplayed();
	}
	
	public void scrollUntilVisible(WebDriver driver, By element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(element);
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}
	
	public void scrollUntilVisible(WebDriver driver, int height) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+height+")", "");
	}
	
	public void setSize(WebDriver driver, int width, int height) {
		Dimension dimensions = new Dimension(width, height);
		driver.manage().window().setSize(dimensions);
	}
	
	public void waitUntilVisible(WebDriver driver,By element) {
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public void waitUntilValuePresent(WebDriver driver,By element,String value) {
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.textToBePresentInElementValue(element,value));
	}
	
	public void waitUntilTextPresent(WebDriver driver,By element,String value) {
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(element,value));
	}
	
	public void waitUntilPageTitle(WebDriver driver,String value) {
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.titleContains(value));
	}
	
	public void waitUntilClikable(WebDriver driver,By element) {
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void hover(WebDriver driver, By automotive, By carLights) throws InterruptedException {
		WebElement element = driver.findElement(automotive);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		Thread.sleep(1);
		driver.findElement(carLights).click();
	}
	
}
