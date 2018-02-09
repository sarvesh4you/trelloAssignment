/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartassistant.automation.getpageobjects;

import static com.smartassistant.automation.getpageobjects.ObjectFileReader.getPageTitleFromFile;
import static com.smartassistant.automation.utils.PropertyFileReaderAndWriter.getPropertyFromConfig;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BaseUi {

	WebDriver driver;
	protected WebDriverWait wait;
	private String pageName;

	protected BaseUi(WebDriver driver, String pageName) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.pageName = pageName;
		this.wait = new WebDriverWait(driver, Integer.parseInt(getPropertyFromConfig("timeout")));
		

	}

	protected void logMessage(String message) {
		Reporter.log(message, true);
	}

	/**
	 * Verification of the page title with the title text provided in the page
	 * object repository
	 * 
	 */
	protected void verifyPageTitleContains() {
		String expectedPagetitle = getPageTitleFromFile(pageName).trim();
		try {
			
			wait.until(ExpectedConditions.titleContains(expectedPagetitle));
			logMessage("TEST PASSED: PageTitle contains: '" + expectedPagetitle + "'.");
		} catch (TimeoutException exp) {
			String actualPageTitle = driver.getTitle().trim();
			logMessage("TEST FAILED: As actual Page Title: '" + actualPageTitle
					+ "' does not contain expected Page Title : '" + expectedPagetitle + "'.");
		}
	}

	/**
	 * Scroll down page up to the element
	 */
	protected void scrollDown(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Click on the element
	 */
	protected void click(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			scrollDown(element);
			element.click();
		} catch (StaleElementReferenceException ex1) {
			wait.until(ExpectedConditions.visibilityOf(element));
			scrollDown(element);
			element.click();
			logMessage("Clicked Element " + element + " after catching Stale Element Exception");
		} catch (Exception ex2) {
			logMessage("Element " + element + " could not be clicked! " + ex2.getMessage());
		}
	}

	/**
	 * Enter text into the textfield
	 */
	protected void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.clear();
		element.sendKeys(text);

	}

}
