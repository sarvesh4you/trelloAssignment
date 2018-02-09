package com.smartassistant.automation.getpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;
import static org.testng.Assert.assertTrue;
import static com.smartassistant.automation.getpageobjects.ObjectFileReader.getELementFromFile;

public class GetPage extends BaseUi {

	protected WebDriver webdriver;
	String pageName;

	public GetPage(WebDriver driver, String pageName) {
		super(driver, pageName);
		this.webdriver = driver;
		this.pageName = pageName;
	}

	
	protected WebElement element(String elementToken) {
		return element(elementToken, "");
	}

	protected WebElement element(String elementToken, String replacement1, String replacement2)
			throws NoSuchElementException {
		WebElement elem = null;
		try {
			elem = wait.until(ExpectedConditions.visibilityOf(
					webdriver.findElement(getLocator(elementToken, replacement1, replacement2))));
		} catch (NoSuchElementException excp) {
			fail("FAILED: Element " + elementToken + " not found on the " + this.pageName + " !!!");
		}
		return elem;
	}

	protected WebElement element(String elementToken, String replacement) throws NoSuchElementException {
		WebElement elem = null;
		try {
			elem = wait.until(ExpectedConditions.visibilityOf(webdriver.findElement(getLocator(elementToken, replacement))));

		} catch (NoSuchElementException excp) {
			fail("FAILED: Element '" + elementToken + "' not found on the " + this.pageName + " !!!");
		}
		return elem;
	}

	

	protected boolean isElementDisplayed(String elementName, String elementTextReplace) {
		wait.until(ExpectedConditions.visibilityOf(element(elementName, elementTextReplace)));
		boolean result = element(elementName, elementTextReplace).isDisplayed();
		assertTrue(result,
				"TEST FAILED: element '" + elementName + "with text " + elementTextReplace + "' is not displayed.");
		logMessage("TEST PASSED: element " + elementName + " with text " + elementTextReplace + " is displayed.");
		return result;
	}

	protected boolean isElementDisplayed(String elementName) {
		wait.until(ExpectedConditions.visibilityOf(element(elementName)));
		boolean result = element(elementName).isDisplayed();
		assertTrue(result, "TEST FAILED: element '" + elementName + "' is not displayed.");
		logMessage("TEST PASSED: element " + elementName + " is displayed.");
		return result;
	}

	

	protected By getLocator(String elementToken, String replacement) {
		String[] locator = getELementFromFile(this.pageName, elementToken);
		locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
		return getBy(locator[1].trim(), locator[2].trim());
	}

	protected By getLocator(String elementToken, String replacement1, String replacement2) {
		String[] locator = getELementFromFile(this.pageName, elementToken);

		locator[2] = locator[2].replaceFirst("\\$\\{.+?\\}", replacement1);
		locator[2] = locator[2].replaceFirst("\\%\\{.+?\\}", replacement2);

		return getBy(locator[1].trim(), locator[2].trim());
	}

	private By getBy(String locatorType, String locatorValue) {
		switch (Locators.valueOf(locatorType)) {
		case id:
			return By.id(locatorValue);
		case xpath:
			return By.xpath(locatorValue);
		case css:
			return By.cssSelector(locatorValue);
		case name:
			return By.name(locatorValue);
		case classname:
			return By.className(locatorValue);
		case linktext:
			return By.linkText(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}

}
